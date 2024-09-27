package com.lisdatasolutions.lisdata.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lisdatasolutions.lisdata.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  // @ManyToOne //por default es EAGER, carga ansiosa de la data user 
  @ManyToOne(fetch=FetchType.LAZY) // los datos solo se cargarán cuando llame a vehicle.getUser()
  @JoinColumn(name = "user_id", nullable=false)
  @JsonBackReference // para que cuando llame a user.getVehicles() el user no se serialice
  private User user;

  private String color;

  @Column(nullable = false)
  private boolean active;
}