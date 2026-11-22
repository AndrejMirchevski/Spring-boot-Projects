package com.andrej.Real_estate_listing_api.repository;

import com.andrej.Real_estate_listing_api.entity.Listing;
import com.andrej.Real_estate_listing_api.entity.enums.ListingStatus;
import com.andrej.Real_estate_listing_api.entity.enums.PropertyType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    Optional<Listing> findByIdAndDeletedAtIsNull(Long id);

    @Query("""
            Select l FROM Listing l
            WHERE l.deletedAt IS NULL
                AND (:city IS NULL OR LOWER(l.city) = :city)
                AND (:type IS NULL OR l.type = :type)
                AND (:status IS NULL OR l.status = :status)
                AND (:minPrice IS NULL OR l.price >= :minPrice)
                AND (:maxPrice IS NULL OR l.price <= :maxPrice)
""")
    Page<Listing> search(@Param("city") String city,
                         @Param("type") PropertyType type,
                         @Param("status") ListingStatus status,
                         @Param("minPrice") BigDecimal minPrice,
                         @Param("maxPrice") BigDecimal maxPrice,
                         Pageable pageable);
    @Query("""
            SELECT l.city AS city, COUNT(l) AS count
            FROM Listing l
            WHERE l.status = :status AND l.deletedAt IS NULL
            GROUP BY l.city
            ORDER BY COUNT(l) DESC
            """)
    List<CityCount> countByCityAndStatus(@Param("status") ListingStatus status);

    // Projection: Spring fills this interface from the query's "AS city" / "AS count" aliases
    interface CityCount {
        String getCity();
        Long getCount();
    }
}
