package com.boots.service;

import com.boots.dto.FlightDTO;

import java.util.List;

public interface FlightService {

    List<FlightDTO> getAllFlights();

    FlightDTO createFlight(FlightDTO flightDTO);

    void deleteFlight(Long flightId);
}
