package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("file:C:\\Users\\narapell\\propertiesfile\\application.properties")
public class SecondAppWithTileApplication extends SpringBootServletInitializer{

    @Override
 protected SpringApplicationBuilder configure(SpringApplicationBuilder 
 application) {
    return application.sources(SecondAppWithTileApplication.class);
 }

	public static void main(String[] args) {
		SpringApplication.run(SecondAppWithTileApplication.class, args);
	}

}
