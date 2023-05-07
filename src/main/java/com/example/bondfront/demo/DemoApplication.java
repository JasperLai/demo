package com.example.bondfront.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bondfront.demo.domain.ebond.model.domainObject.QuotaApplyMessage;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		QuotaApplyMessage qam = new QuotaApplyMessage();
		System.out.println(qam.getId());
	}

}
