package com.lisdatasolutions.lisdata.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisdatasolutions.lisdata.user.User;
import com.lisdatasolutions.lisdata.user.UserNotFoundException;
import com.lisdatasolutions.lisdata.user.UserRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository cr;
    @Autowired
    private UserRepository userRepository;
    
    public Car createCar(Car car, int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        car.setUser(user);
        return cr.save(car);
    }
    public List<Car> getCars(){
        return cr.findAll();
    }
    public Car updateCar(int id, Car updatedCar){
        Car car = cr.findById(id).orElse(null);
        if(car != null){
            car.setColor(updatedCar.getColor());
            car.setActive(updatedCar.isActive());
            car.setPlate(updatedCar.getPlate());
            car.setCapacity(updatedCar.getCapacity());
            car.setElectrical(updatedCar.isElectrical());
            
            return cr.save(car);
        }else{
            throw new CarNotFoundException("Car not found");
        }
    }
    
    public boolean deleteCar(int id){
        Car car = cr.findById(id).orElse(null);
        if(car != null){
            cr.deleteById(id);
            return true;
        }else{
            throw new CarNotFoundException("Car not found");
        }
    }
    
    public List<Car> getActiveCars(){
        return cr.findByActiveTrue();
    }
    public List<Car> getActiveCarsByUser(int userId){
        return cr.findByUserIdAndActiveTrue(userId);
    }
    
}