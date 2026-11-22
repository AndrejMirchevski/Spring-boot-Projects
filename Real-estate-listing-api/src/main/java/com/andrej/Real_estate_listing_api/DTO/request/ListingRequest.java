//used by POST and PUT

package com.andrej.Real_estate_listing_api.DTO.request;

import com.andrej.Real_estate_listing_api.entity.enums.ListingKind;
import com.andrej.Real_estate_listing_api.entity.enums.PropertyType;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ListingRequest(
        @NotBlank
        @Size(max = 200)
        String title,

        @NotNull
        PropertyType type,

        @NotNull
        ListingKind listingKind,

        @NotNull
        @DecimalMin(value = "0.01")
        @Digits(integer = 10, fraction = 2)
        BigDecimal price,

        @NotBlank
        @Pattern(regexp = "^[A-Z]{3}$", message = "Must be a 3 letter uppercase code like EUR")
        String currency,

        @NotBlank
        @Size(max = 100)
        String city,

        @Min(0)
        Integer bedrooms,

        @Min(0)
        Integer bathrooms,

        @Positive
        Integer sqm
) {
}
