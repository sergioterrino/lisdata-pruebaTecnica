package com.lisdatasolutions.lisdata.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public Type createType(String description) {
        Type type = new Type();
        type.setDescription(description);
        return typeRepository.save(type);
    }

    public Optional<Type> getTypeById(int id) {
        return typeRepository.findById(id);
    }

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    public Type updateType(int id, String description) {
        Type type = typeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Type not found"));
        type.setDescription(description);
        return typeRepository.save(type);
    }

    public void deleteType(int id) {
        typeRepository.deleteById(id);
    }
}