package com.kaps.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan({"com.kaps.aws", "com.kaps.aws.rds.repository", "com.kaps.aws.rds.entity"})
//@EnableJpaRepositories( basePackages =  "com.kaps.aws.rds.repository")
//@EntityScan( basePackages = "com.kaps.aws.rds.entity")
public class AwsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsDemoApplication.class, args);
	}
}
