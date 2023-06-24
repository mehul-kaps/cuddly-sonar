package com.kaps.jacocosandbox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringServiceTest {

	@Before
	public void init() {
		System.out.println("Init called");
	}
	
	@Test
	public void test_1() {
		String value = StringService.getValue();
		System.out.println("Value from class: " + value);
		Assert.assertEquals("Something went wrong", "Hello", value);
	}
}
