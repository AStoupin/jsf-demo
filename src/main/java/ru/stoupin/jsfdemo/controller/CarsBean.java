package ru.stoupin.jsfdemo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.stoupin.jsfdemo.domain.Car;
import ru.stoupin.jsfdemo.service.CarService;


@Scope(value = "session")
@Component("cars")
public class CarsBean implements Serializable {
     
    private List<Car> cars;
    private CarService service;
    
    
    @Autowired
    CarsBean(CarService service){
    	this.service = service;
		cars = service.createCars(50);
    }
    public List<Car> getCars() {
        return cars;
    }
 

}