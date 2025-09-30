package com.spring.producer.dto;

public record RiderLocation(
    String riderId,
    double latitude,
    double longitude
) {
} 
