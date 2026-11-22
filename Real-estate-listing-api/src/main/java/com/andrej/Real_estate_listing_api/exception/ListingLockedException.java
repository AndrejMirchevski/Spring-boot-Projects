package com.andrej.Real_estate_listing_api.exception;

import com.andrej.Real_estate_listing_api.entity.enums.ListingStatus;

public class ListingLockedException extends ConflictException {
    public ListingLockedException(Long listingId, ListingStatus status) {
        super("Listing: " + listingId + " is " + status + " and can no longer be modified");
    }
}
