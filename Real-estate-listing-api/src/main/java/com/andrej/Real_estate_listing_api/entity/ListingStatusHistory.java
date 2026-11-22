package com.andrej.Real_estate_listing_api.entity;

import com.andrej.Real_estate_listing_api.entity.enums.ListingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "Listing_history")
@Getter @Setter @NoArgsConstructor
public class ListingStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    private ListingStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ListingStatus toStatus;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant changedAt;
}
