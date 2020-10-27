package ru.stoupin.jsfdemo.service;

import org.springframework.stereotype.Service;

import ru.stoupin.jsfdemo.domain.HelloData;

@Service
public class HelloService {

	public HelloData getHelloData() {
		return new HelloData();
	}
}
