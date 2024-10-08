package com.lisdatasolutions.lisdata.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lisdatasolutions.lisdata.vehicle.Vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable=false, length=50)
  private String name;

  @Column(nullable=false, length=200)
  private String email;

  @Column(nullable = false, length=15)
  private String phone;

  private int age;

  @Column(nullable = false)
  private boolean active;

  // opcional: mappedBy = "user" indica que la relación es bidireccional.
  // LAZY indica que no se carguen los vehicles al cargar el usuario
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonManagedReference // stop referencia circular. la list vehicles si se serializa.
  private List<Vehicle> vehicles;
  
}
