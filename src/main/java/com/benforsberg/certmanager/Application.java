package com.benforsberg.certmanager;

import com.benforsberg.certmanager.Drivers.TestClass1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		TestClass1 testClass1 = new TestClass1();
		testClass1.Driver();
	}
}
