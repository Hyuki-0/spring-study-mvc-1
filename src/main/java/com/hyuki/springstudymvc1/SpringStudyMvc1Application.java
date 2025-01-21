package com.hyuki.springstudymvc1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // Servlet Auto Registry
@SpringBootApplication
public class SpringStudyMvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyMvc1Application.class, args);
	}

}
