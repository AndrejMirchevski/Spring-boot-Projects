package com.andrej.Real_estate_listing_api.repository;

import com.andrej.Real_estate_listing_api.entity.Inquiry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    Page<Inquiry> findByListingId(Long listingId, Pageable pageable);
}
