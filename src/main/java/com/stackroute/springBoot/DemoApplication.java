package com.stackroute.springBoot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Component
//@RestController
public class DemoApplication {

	/*@RequestMapping("/")
	String home(){
		return "Hello World" +
				"How are you";
	}*/


	public static void main(String[] args) {
		System.out.println("Hello");
		//System.out.println(new DemoApplication().s);
		//System.out.println(new EnvironComponent().getMessage());
		SpringApplication.run(DemoApplication.class,args);

		//System.out.println(new DemoApplication().userRepository.findByFirstName("Abinash"));
	}

}
