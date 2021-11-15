package com.boots.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@JsonSerialize
@Data
@Builder(toBuilder = true)
public class FlightDTO {

    private Long id;

    private String carrierCodeIATA;

    private Integer flightNumber;

    private Date flightDate;

    private String origin;

    private String destination;
}
