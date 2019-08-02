package com.stackroute.springBoot;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
//@RestController
public class DemoApplication {

	/*@RequestMapping("/")
	String home(){
		return "Hello World" +
				"How are you";
	}*/


	public static void main(String[] args) {
		//System.out.println(new DemoApplication().environment.getClass());
		SpringApplication.run(DemoApplication.class,args);

		//System.out.println(new DemoApplication().userRepository.findByFirstName("Abinash"));
	}

}
