package com.andrej.Real_estate_listing_api.DTO.response;

import com.andrej.Real_estate_listing_api.entity.ListingStatusHistory;
import com.andrej.Real_estate_listing_api.entity.enums.ListingStatus;

import java.time.Instant;

public record StatusHistoryResponse(
        Long id,
        Long listingId,
        ListingStatus fromStatus,
        ListingStatus toStatus,
        Instant changedAt
) {
    public static StatusHistoryResponse from(ListingStatusHistory h){
        return new StatusHistoryResponse(
                h.getId(),
                h.getListing().getId(),
                h.getFromStatus(),
                h.getToStatus(),
                h.getChangedAt()
        );
    }
}
