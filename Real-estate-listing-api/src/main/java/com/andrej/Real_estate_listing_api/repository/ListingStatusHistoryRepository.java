package com.andrej.Real_estate_listing_api.repository;

import com.andrej.Real_estate_listing_api.entity.ListingStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListingStatusHistoryRepository extends JpaRepository<ListingStatusHistory, Long> {
    Page<ListingStatusHistory> findByListingIdOrderByChangedAtAsc(Long listingId, Pageable pageable);
}
