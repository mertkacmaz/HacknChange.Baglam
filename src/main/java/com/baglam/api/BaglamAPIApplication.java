package com.baglam.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baglam.api.algorithm.SlopeOne;

@SpringBootApplication
public class BaglamAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaglamAPIApplication.class, args);
		new SlopeOne();
	}

}