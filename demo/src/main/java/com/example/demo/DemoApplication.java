package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.agentskiModel.GetSmestajRequest;
import com.example.demo.agentskiModel.GetSmestajResponse;
import com.example.demo.agentskiModel.Smestaj;
import com.example.demo.agentskiModel.SmestajServicePort;
import com.example.demo.agentskiModel.SmestajServicePortService;


@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello Mavene Jodza");
		Date d = new Date();
		System.out.println(d);
	}
}
