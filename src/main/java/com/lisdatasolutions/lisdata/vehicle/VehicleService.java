package com.lisdatasolutions.lisdata.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    public VehicleRepository vehicleRepository;
    
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }
    public List<Vehicle> getActiveVehicles(){
        return vehicleRepository.findByActiveTrue();
    }
    public List<Vehicle> getVehiclesByUser(int userId){
        return vehicleRepository.findByUserId(userId);
    }
    public List<Vehicle> getActiveVehiclesByUser(int userId){
        return vehicleRepository.findByUserIdAndActiveTrue(userId);
    }
}
