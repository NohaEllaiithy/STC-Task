package com.digivision.Multi_tenant_Property_Rent.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingDTO {
    private Long id;

    @NotNull(message = "Property ID is mandatory")
    private Long propertyId;

    @NotNull(message = "User ID is mandatory")
    private Long userId;

    @FutureOrPresent(message = "Start date must be in the present or future")
    @NotNull(message = "Start date is mandatory")
    private LocalDate startDate;

    @FutureOrPresent(message = "End date must be in the present or future")
    @NotNull(message = "End date is mandatory")
    private LocalDate endDate;
}