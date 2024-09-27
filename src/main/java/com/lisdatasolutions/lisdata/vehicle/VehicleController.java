package com.lisdatasolutions.lisdata.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles() {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        return ResponseEntity.ok(vehicles);
    }

    // Get vehicles through User.getVehicles()
    @GetMapping("/getvehiclesv2")
    public ResponseEntity<List<Vehicle>> getVehiclesv2() {
        List<Vehicle> vehicles = vehicleService.getVehiclesv2();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Vehicle>> getActiveVehicles() {
        List<Vehicle> activeVehicles = vehicleService.getActiveVehicles();
        return ResponseEntity.ok(activeVehicles);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByUser(@PathVariable int userId) {
        List<Vehicle> userVehicles = vehicleService.getVehiclesByUser(userId);
        return ResponseEntity.ok(userVehicles);
    }

    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<Vehicle>> getActiveVehiclesByUser(@PathVariable int userId) {
        List<Vehicle> activeUserVehicles = vehicleService.getActiveVehiclesByUser(userId);
        return ResponseEntity.ok(activeUserVehicles);
    }
}
