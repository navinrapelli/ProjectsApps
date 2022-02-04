package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@SpringBootApplication
@ImportResource("classpath:/spring/security-context.xml")
public class newtileapplication extends SpringBootServletInitializer {





	@Override
 protected SpringApplicationBuilder configure(SpringApplicationBuilder 
 application) {
    return application.sources(newtileapplication.class);
 }
	
	
	public static void main(String[] args) {
		SpringApplication.run(newtileapplication.class, args);
	}


	
	
}
