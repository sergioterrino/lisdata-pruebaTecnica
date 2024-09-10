package com.lisdatasolutions.lisdata.car;

import com.lisdatasolutions.lisdata.vehicle.Vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)  // Incluir equals/hashCode de la clase padre (Vehicle)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car extends Vehicle{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, length = 30)
  private char plate;
  private int capacity;
  private boolean electrical;
}
