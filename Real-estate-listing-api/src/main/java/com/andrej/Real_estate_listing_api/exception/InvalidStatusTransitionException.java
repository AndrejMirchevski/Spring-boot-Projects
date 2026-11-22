package com.andrej.Real_estate_listing_api.exception;

import com.andrej.Real_estate_listing_api.entity.enums.ListingStatus;

public class InvalidStatusTransitionException extends ConflictException {
    public InvalidStatusTransitionException(ListingStatus from, ListingStatus to) {
        super("Cannot change status from " + from + " to " + to);
    }
}
