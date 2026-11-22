package com.andrej.Real_estate_listing_api.entity;

import com.andrej.Real_estate_listing_api.entity.enums.ListingKind;
import com.andrej.Real_estate_listing_api.entity.enums.ListingStatus;
import com.andrej.Real_estate_listing_api.entity.enums.PropertyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "Listing")
@Getter @Setter @NoArgsConstructor
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type", nullable = false)
    private PropertyType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "listing_kind", nullable = false)
    private ListingKind listingKind;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false)
    private String city;

    private Integer bedrooms;
    private Integer bathrooms;
    private Integer sqm;

    @Enumerated(EnumType.STRING)
    @Column(name = "Listing_status", nullable = false)
    private ListingStatus status = ListingStatus.ACTIVE;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    private Instant deletedAt;

    public boolean isLocked(){
        return status == ListingStatus.RENTED || status == ListingStatus.SOLD;
    }
}
