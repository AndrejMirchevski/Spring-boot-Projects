package com.andrej.Real_estate_listing_api.DTO.response;

import com.andrej.Real_estate_listing_api.entity.Listing;
import com.andrej.Real_estate_listing_api.entity.enums.ListingKind;
import com.andrej.Real_estate_listing_api.entity.enums.ListingStatus;
import com.andrej.Real_estate_listing_api.entity.enums.PropertyType;

import java.math.BigDecimal;
import java.time.Instant;

public record ListingResponse(
        Long id,
        String title,
        PropertyType type,
        ListingKind listingKind,
        BigDecimal price,
        String currency,
        String city,
        Integer bedrooms,
        Integer bathrooms,
        Integer sqm,
        ListingStatus status,
        Instant createdAt,
        Instant updatedAt
) {

    public static ListingResponse from(Listing l){
        return new ListingResponse(
                l.getId(),
                l.getTitle(),
                l.getType(),
                l.getListingKind(),
                l.getPrice(),
                l.getCurrency(),
                l.getCity(),
                l.getBedrooms(),
                l.getBathrooms(),
                l.getSqm(),
                l.getStatus(),
                l.getCreatedAt(),
                l.getUpdatedAt()
        );
    }
}
