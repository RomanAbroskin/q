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
@Table(name = "Aircrafts")
public class Aircrafts {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String aircraft_code;
        private String model;
        private double range;

        @ManyToMany(mappedBy = "flights")
        @ToString.Exclude
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        private List<Flights> fir;

        @OneToOne
        @JoinColumn(name="Aircrafts", referencedColumnName = "aircraft_code")
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        private Seats seats;

    public Aircrafts(String aircraft_code, String model, double range) {
        this.aircraft_code = aircraft_code;
        this.model = model;
        this.range = range;
    }
}
