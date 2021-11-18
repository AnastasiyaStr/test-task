package com.boots.service.impl;

import com.boots.dto.FlightDTO;
import com.boots.entity.Flight;
import com.boots.exception.EntityDoesNotExistException;
import com.boots.mapper.FlightDTOMapper;
import com.boots.repository.FlightRepository;
import com.boots.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private static final String FLIGHT_NOT_FOUND_MESSAGE = "Could not find flight by id: %s";

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightDTOMapper flightDTOMapper;


    @Override
    public List<FlightDTO> getAllFlights() {

        List<Flight> flights = flightRepository.findAll();

        return flights.stream().map(flight ->
                flightDTOMapper.fromFlight(flight)
        ).collect(Collectors.toList());

    }

    @Override
    public FlightDTO getFlightById(Long id) {

        Flight flight = flightRepository.findById(id).orElseThrow(() ->
                new EntityDoesNotExistException(FLIGHT_NOT_FOUND_MESSAGE));

        return flightDTOMapper.fromFlight(flight);

    }

    @Override
    public FlightDTO createFlight(FlightDTO flightDTO) {

        Flight saved = flightRepository.save(flightDTOMapper.fromFlightDTO(flightDTO));

        return flightDTOMapper.fromFlight(saved);
    }


    @Override
    public void deleteFlight(Long flightId) {

        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new EntityDoesNotExistException(String.format(FLIGHT_NOT_FOUND_MESSAGE, flightId)));

        flightRepository.delete(flight);

    }

}
