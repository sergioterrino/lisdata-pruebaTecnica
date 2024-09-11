package com.lisdatasolutions.lisdata.bike;

import java.util.List;

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
@RequestMapping("/api/bikes")
public class BikeController {
    @Autowired
    private BikeService bs;
    
    @GetMapping("")
    public ResponseEntity<List<Bike>> getCars(){
        List<Bike> bikes = bs.getBikes();
        return bikes.size() > 0 ? new ResponseEntity<>(bikes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Bike> createBike(@RequestBody Bike bike, @RequestParam int userId, @RequestParam int typeId) {
        Bike createdBike = bs.createBike(bike, userId, typeId);
        return new ResponseEntity<>(createdBike, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable int id, @RequestBody Bike updatedBike){
      Bike bike = bs.updateBike(id, updatedBike);
        return new ResponseEntity<>(bike, HttpStatus.OK);
    } 

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable int id){
        bs.deleteBike(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}
