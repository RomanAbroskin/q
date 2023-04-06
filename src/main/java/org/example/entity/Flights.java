package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;


    @Entity
    @Data
    @NoArgsConstructor
    @Table(name = "Flights")
public class Flights {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String flight_code;
        private String flight_no;
        private String scheduled_departure;
        private String scheduled_arrival;
        private String departure_airport;
        private String arrival_airport;
        private String status;
        private String aircraft_code;
        private String actual_departure;
        private String actual_arrival;
        @ManyToMany
        @JoinColumn(name="Flights", referencedColumnName = "flight_code")
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        private Aircrafts aircrafts;

        public Flights(String flight_code, String flight_no, String scheduled_departure, String scheduled_arrival, String departure_airport, String arrival_airport, String status, String aircraft_code, String actual_departure, String actual_arrival) {
            this.flight_code = flight_code;
            this.flight_no = flight_no;
            this.scheduled_departure = scheduled_departure;
            this.scheduled_arrival = scheduled_arrival;
            this.departure_airport = departure_airport;
            this.arrival_airport = arrival_airport;
            this.status = status;
            this.aircraft_code = aircraft_code;
            this.actual_departure = actual_departure;
            this.actual_arrival = actual_arrival;

        }
    }
