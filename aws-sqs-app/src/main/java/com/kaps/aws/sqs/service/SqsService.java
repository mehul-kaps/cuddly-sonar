package com.kaps.aws.sqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

@Service
public class SqsService {

	@Value("${SQS_QUEUE_URL}")
    String QUEUE_URL;

    @Autowired
    private SqsClient sqsClient;

    public void sendMessage(String messageBody) {
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .messageBody(messageBody)
                .build();
        sqsClient.sendMessage(sendMsgRequest);
    }

    public String receiveMessage(Boolean delete) {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .maxNumberOfMessages(1)
                .build();

        ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(receiveMessageRequest);
        
        if (receiveMessageResponse.messages().isEmpty()) {
            return "No messages received";
        }

        String messageBody = receiveMessageResponse.messages().get(0).body();

        String receiptHandle = receiveMessageResponse.messages().get(0).receiptHandle();
        if(delete)
        	deleteMessage(receiptHandle);  // You might want to delete the message after processing it.
        else 
        	System.out.println("## Message was received, but not deleted from the queue. ");

        return messageBody;
    }

    private void deleteMessage(String receiptHandle) {
        DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .receiptHandle(receiptHandle)
                .build();

        sqsClient.deleteMessage(deleteMessageRequest);
    }
}
