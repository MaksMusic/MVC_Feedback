package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class RegisterOnlineApplicationTests {

	@Test
	void contextLoads() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.getDayOfMonth());
	}

}
