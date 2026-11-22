package com.andrej.Real_estate_listing_api.DTO.request;

import com.andrej.Real_estate_listing_api.entity.enums.ListingStatus;
import jakarta.validation.constraints.NotNull;

public record StatusChangeRequest(
        @NotNull
        ListingStatus status
) {
}
