package com.taskify.milestone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MilestoneApplication {
    public static void main(String[] args) {
      SpringApplication.run(MilestoneApplication.class, args);
    }
	//Endpoint start
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
	//Made a couple of test to see if the name changes within the URL
    }

	
}
	

	

