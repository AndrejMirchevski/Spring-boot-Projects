package com.andrej.Real_estate_listing_api.DTO.response;

import com.andrej.Real_estate_listing_api.entity.AuditLog;
import com.andrej.Real_estate_listing_api.entity.enums.AuditAction;

import java.time.Instant;

public record AuditLogResponse(
        Long id,
        String entityType,
        Long entityId,
        AuditAction action,
        String details,
        Instant timeStamp
) {
    public static AuditLogResponse from(AuditLog a){
        return new AuditLogResponse(
                a.getId(),
                a.getEntityType(),
                a.getEntityId(),
                a.getAction(),
                a.getDetails(),
                a.getTimeStamp()
        );
    }
}
