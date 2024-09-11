package com.lisdatasolutions.lisdata.bike;

import com.lisdatasolutions.lisdata.type.Type;
import com.lisdatasolutions.lisdata.user.User;
import com.lisdatasolutions.lisdata.vehicle.Vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)  // Incluir equals/hashCode de la clase padre (Vehicle)
@AllArgsConstructor
@Table(name = "bike")
public class Bike extends Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private boolean basket;

  @ManyToOne
  @JoinColumn(name="type_id", nullable=false)
  private Type type;

  @ManyToOne
  @JoinColumn(name = "user_id", updatable = false)
  private User user;
}