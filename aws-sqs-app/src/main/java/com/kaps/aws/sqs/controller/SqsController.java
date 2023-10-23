package com.kaps.aws.sqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaps.aws.sqs.service.SqsService;

/**
 * 
 * @author mehulkapadia
 *
 */
@RestController
public class SqsController {

    @Autowired
    private SqsService sqsService;
    
    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        sqsService.sendMessage(message);
        return "Message sent!";
    }

    @GetMapping("/receive")
    public String receiveMessage() {
    	String message = "";
    	try {
    		message = sqsService.receiveMessage();
    	}
    	catch(Exception ex) {
    		message = "Cause:" + ex.getClass() + " ErrorMessage:" + ex.getMessage();
    	}
        return message;
    }  
    
    @GetMapping("/receive_without_delete")
    public String receiveMessageWithoutDelete() {
    	String message = "";
    	try {
    		message = sqsService.receiveMes sage(Boolean.FALSE);
    	}
    	catch(Exception ex) {
    		message = "Cause:" + ex.getClass() + " ErrorMessage:" + ex.getMessage();
    	}
        return message;
    } 
}
