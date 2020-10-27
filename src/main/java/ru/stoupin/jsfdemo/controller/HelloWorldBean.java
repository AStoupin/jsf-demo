package ru.stoupin.jsfdemo.controller;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.stoupin.jsfdemo.domain.HelloData;
import ru.stoupin.jsfdemo.service.HelloService;

@Scope(value = "session")
@Component("helloworld")
public class HelloWorldBean implements Serializable {
	static final Logger log = LogManager.getLogger(HelloWorldBean.class);
	
	
	private HelloService helloService;
	
	private HelloData helloData = null;
	
	@Autowired
	public HelloWorldBean(HelloService helloService) {
		log.info("HelloWorldBean init");
		this.helloService = helloService;

	}

	public String getMessage() {
		return "Hello World from JSF ";
	}

	public HelloData getHelloData() {
		if(helloData==null) {
			helloData = helloService.getHelloData();
		}
		
		return helloData;
	}
	
	public String buttonAction() throws InterruptedException {
		Thread.sleep(1000);

		return "";
	}



}