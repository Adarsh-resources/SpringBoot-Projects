package com.hotelservice.exceptions;

public class ResourceNotFoundException extends  RuntimeException {
    public ResourceNotFoundException( String s) {
        super("Resource not found !!");

    }
}
