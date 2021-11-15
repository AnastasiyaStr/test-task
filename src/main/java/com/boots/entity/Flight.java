package com.boots.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flights")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "carrier_code_IATA")
    private String carrierCodeIATA;

    @Column(name = "flight_number")
    private Integer flightNumber;

    @Column(name = "flight_date")
    private Date flightDate;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;
}
