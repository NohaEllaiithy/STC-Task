package com.digivision.Multi_tenant_Property_Rent.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class PropertyDTO {


    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotNull(message = "Owner ID is mandatory")
    private String ownerId;
}