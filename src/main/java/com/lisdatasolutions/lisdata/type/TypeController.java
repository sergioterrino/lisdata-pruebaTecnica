package com.lisdatasolutions.lisdata.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping("/create")
    public ResponseEntity<Type> createType(@RequestBody Type type) {
        Type createdType = typeService.createType(type.getDescription());
        return new ResponseEntity<>(createdType, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable int id) {
        return typeService.getTypeById(id)
                .map(type -> new ResponseEntity<>(type, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Type>> getTypes() {
        List<Type> types = typeService.getTypes();
        return types.size() > 0 ? new ResponseEntity<>(types, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Type> updateType(@PathVariable int id, @RequestBody Type type) {
        Type updatedType = typeService.updateType(id, type.getDescription());
        return new ResponseEntity<>(updatedType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable int id) {
        typeService.deleteType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}