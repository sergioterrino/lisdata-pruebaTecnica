package com.lisdatasolutions.lisdata.dto;

import com.lisdatasolutions.lisdata.user.User;
import com.lisdatasolutions.lisdata.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserWithInactiveVehicles {
    private User user;
    private List<Vehicle> inactiveVehicles;
}