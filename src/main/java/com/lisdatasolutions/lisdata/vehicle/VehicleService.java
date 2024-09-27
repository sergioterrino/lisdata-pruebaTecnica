package com.lisdatasolutions.lisdata.vehicle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisdatasolutions.lisdata.user.User;
import com.lisdatasolutions.lisdata.user.UserService;

@Service
public class VehicleService {
    @Autowired
    public VehicleRepository vehicleRepository;
    @Autowired
    private UserService userService;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    // Get vehicles through User.getVehicles()
    public List<Vehicle> getVehiclesv2() {
        List<User> users = userService.getUsers();
        List<Vehicle> vehicles = users.stream()
                // como tengo una lista users anidada con una lista vehicles
                // necesito aplanar para tener solo una lista
                .flatMap(u -> u.getVehicles().stream()) // convert la ist de vehicles del user en un Stream de vehicles
                                                        // general
                .collect(Collectors.toList()); // recojo todos los elem del Stream en una lista
        return vehicles;
    }

    public List<Vehicle> getActiveVehicles() {
        return vehicleRepository.findByActiveTrue();
    }

    public List<Vehicle> getVehiclesByUser(int userId) {
        return vehicleRepository.findByUserId(userId);
    }

    public List<Vehicle> getActiveVehiclesByUser(int userId) {
        return vehicleRepository.findByUserIdAndActiveTrue(userId);
    }
}
