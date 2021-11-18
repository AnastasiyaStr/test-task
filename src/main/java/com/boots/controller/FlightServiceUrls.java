package com.boots.controller;

public interface FlightServiceUrls {

    public interface Flight {
        String ADD = "/flight/add";
        String GET_ALL = "/flight/all";
        String GET = "/flight/{id}";
        String DELETE = "/flight/{id}";

    }

}
