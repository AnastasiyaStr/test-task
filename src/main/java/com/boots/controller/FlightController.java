package com.boots.controller;

import com.boots.dto.FlightDTO;
import com.boots.dto.MessageDTO;
import com.boots.service.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    private static final String FLIGHT_DELETED_MESSAGE = "Successfully deleted flight";

    @Autowired
    private FlightServiceImpl flightService;

    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR', 'ROLE_USER')")
    @GetMapping(value = FlightServiceUrls.Flight.GET)
    public ResponseEntity<List<FlightDTO>> flightsList() {

        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @PostMapping(value = FlightServiceUrls.Flight.ADD)
    public ResponseEntity<FlightDTO> createFlight(
            @RequestBody FlightDTO flightDTO
    ) {

        return new ResponseEntity<>(flightService.createFlight(flightDTO), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @DeleteMapping(value = FlightServiceUrls.Flight.DELETE)
    public ResponseEntity<MessageDTO> deleteFlight(@PathVariable Long id) {

        flightService.deleteFlight(id);

        return new ResponseEntity<>(new MessageDTO(FLIGHT_DELETED_MESSAGE), HttpStatus.OK);
    }

}
