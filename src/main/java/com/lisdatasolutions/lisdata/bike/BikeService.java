package com.lisdatasolutions.lisdata.bike;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisdatasolutions.lisdata.dto.BikeDto;
import com.lisdatasolutions.lisdata.type.Type;
import com.lisdatasolutions.lisdata.type.TypeRepository;
import com.lisdatasolutions.lisdata.user.User;
import com.lisdatasolutions.lisdata.user.UserNotFoundException;
import com.lisdatasolutions.lisdata.user.UserRepository;

@Service
public class BikeService {
    @Autowired
    private BikeRepository br;    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TypeRepository typeRepository;
    
    public Bike createBike(Bike bike, int userId, int typeId){
        Type type = typeRepository.findById(typeId)
                .orElseThrow(() -> new IllegalArgumentException("Type not found"));
        bike.setType(type);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        bike.setUser(user);
        return br.save(bike);
    }

    public List<Bike> getBikes(){
        return br.findAll();
    }

    public Bike updateBike(int id, BikeDto bikeDto){
        Bike bike = br.findById(id).orElse(null);
        if(bike != null){
            bike.setColor(bikeDto.getColor());
            bike.setActive(bikeDto.isActive());
            bike.setBasket(bikeDto.isBasket());
            Type type = typeRepository.findById(bikeDto.getTypeId())
                    .orElseThrow(() -> new IllegalArgumentException("Type not found"));
            bike.setType(type);
            
            return br.save(bike);
        }else{
            throw new BikeNotFoundException("Bike not found");
        }
    }
    
    public boolean deleteBike(int id){
        Bike bike = br.findById(id).orElse(null);
        if(bike != null){
            br.deleteById(id);
            return true;
        }else{
            throw new BikeNotFoundException("Bike not found");
        }
    }
    
    public List<Bike> getActiveBikes(){
        return br.findByActiveTrue();
    }
    
    public List<Bike> getActiveBikesByUser(int userId){
        return br.findByUserIdAndActiveTrue(userId);
    }
    
}