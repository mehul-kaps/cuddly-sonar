package com.kaps.aws.sqs.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class SqsConfig {

    @Bean
    public SqsClient sqsClient() {
    	
        return SqsClient.builder()
               .region(Region.US_EAST_1)
               .credentialsProvider(() -> ProfileCredentialsProvider.create("default").resolveCredentials())
               .build();
        		
        
        //return SqsClient.builder()
                //.region(Region.US_EAST_1)
                //.credentialsProvider(() -> AwsBasicCredentials.create("AKIA4SNHF4VLWV77NOFY", "EB0hNDYMqrQUGydG0EmAILNGb+k+qeNgtop5BAv2"))
                //.build();
    }
}
