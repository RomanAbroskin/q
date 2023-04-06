package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Seats")
public class Seats {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private String aircraft_code;
 private String fare_conditions;

 @OneToOne(mappedBy = "seats")
 @ToString.Exclude
 @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
 private List<Aircrafts> Air;

 public Seats(String aircraft_code, String fare_conditions) {
  this.aircraft_code = aircraft_code;
  this.fare_conditions = fare_conditions;
 }
}

