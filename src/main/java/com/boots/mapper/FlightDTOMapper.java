package com.boots.mapper;

import com.boots.dto.FlightDTO;
import com.boots.entity.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightDTOMapper {

    public FlightDTO fromFlight(Flight flight) {

        return FlightDTO
                .builder()
                .id(flight.getId())
                .flightDate(flight.getFlightDate())
                .flightNumber(flight.getFlightNumber())
                .carrierCodeIATA(flight.getCarrierCodeIATA())
                .origin(flight.getOrigin())
                .destination(flight.getDestination()).build();
    }

    public Flight fromFlightDTO(FlightDTO flightDTO) {

        return Flight
                .builder()
                .id(flightDTO.getId())
                .flightDate(flightDTO.getFlightDate())
                .flightNumber(flightDTO.getFlightNumber())
                .carrierCodeIATA(flightDTO.getCarrierCodeIATA())
                .origin(flightDTO.getOrigin())
                .destination(flightDTO.getDestination()).build();
    }

}
