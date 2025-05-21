package com.digivision.Multi_tenant_Property_Rent.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingResponseDTO {

    private Long id;
    private Long propertyId;
    private String propertyTitle;
    private Long userId;
    private String userName;
    private LocalDate startDate;
    private LocalDate endDate;
}
