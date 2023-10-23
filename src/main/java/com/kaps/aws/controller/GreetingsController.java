package com.kaps.aws.controller;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kaps.aws.sqs.service.SqsService;
/**
 * 
 * @author mehulkapadia
 *
 */
@RestController
public class GreetingsController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
    @Autowired
    private SqsService sqsService;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(new Greeting(counter.incrementAndGet(), String.format(template, name), UUID.randomUUID().toString()));
		
		System.out.println(json);
		return json;
	}	
}
