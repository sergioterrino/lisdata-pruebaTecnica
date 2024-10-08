package com.lisdatasolutions.lisdata.car;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService cs;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);
    
    @GetMapping("")
    public ResponseEntity<List<Car>> getCars(){
        List<Car> cars = cs.getCars();
        return !cars.isEmpty() ? new ResponseEntity<>(cars, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car, @RequestParam int userId) {
        logger.info("Received request to create car for userId: {}", userId);
        Car createdCar = cs.createCar(car, userId);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car updatedCar){
        Car car = cs.updateCar(id, updatedCar);
        return new ResponseEntity<>(car, HttpStatus.OK);
    } 
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> createCar(@PathVariable int id){
        cs.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}