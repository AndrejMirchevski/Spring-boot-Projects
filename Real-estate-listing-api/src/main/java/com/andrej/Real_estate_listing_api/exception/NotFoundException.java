package com.andrej.Real_estate_listing_api.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String entityName, Long id){
      super(entityName + " with id " + id + " not found");
    }
}
