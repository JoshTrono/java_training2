package com.revature.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.revature.demo.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve the student controller bean from the application context
		StudentController studentController = context.getBean(StudentController.class);

		// Use the student controller to manage student operations
		//
		}

}
