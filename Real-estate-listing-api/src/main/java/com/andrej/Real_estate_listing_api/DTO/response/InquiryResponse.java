package com.andrej.Real_estate_listing_api.DTO.response;

import com.andrej.Real_estate_listing_api.entity.Inquiry;

import java.time.Instant;

public record InquiryResponse(
        Long id,
        Long listingId,
        String name,
        String email,
        String message,
        Instant createdAt
) {

    public static InquiryResponse from(Inquiry i){
        return new InquiryResponse(
                i.getId(),
                i.getListing().getId(),
                i.getName(),
                i.getEmail(),
                i.getMessage(),
                i.getCreatedAt()
        );
    };
}
