package ru.stoupin.jsfdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.stoupin.jsfdemo.controller", "ru.stoupin.jsfdemo.service"})

public class JsfDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsfDemoApplication.class, args);
	}

}
