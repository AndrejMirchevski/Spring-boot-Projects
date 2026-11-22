//used by PATCH

package com.andrej.Real_estate_listing_api.DTO.request;

import com.andrej.Real_estate_listing_api.entity.enums.ListingKind;
import com.andrej.Real_estate_listing_api.entity.enums.PropertyType;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ListingPatchRequest(
        @Size(min = 1, max = 200)
        @Pattern(regexp = ".*\\S.*", message = "Must not be blank")
        String title,

        ListingKind listingKind,

        PropertyType type,

        @DecimalMin(value = "0.01")
        @Digits(integer = 10, fraction = 2)
        BigDecimal price,

        @Pattern(regexp = "^[A-Z]{3}$", message = "must be a 3 letter uppercase code like EUR")
        String currency,

        @Size(min = 1, max = 100)
        @Pattern(regexp = ".*\\S.*", message = "Must not be blank")
        String city,

        @Min(0)
        Integer bedrooms,

        @Min(0)
        Integer bathrooms,

        @Positive
        Integer sqm
) {
}
