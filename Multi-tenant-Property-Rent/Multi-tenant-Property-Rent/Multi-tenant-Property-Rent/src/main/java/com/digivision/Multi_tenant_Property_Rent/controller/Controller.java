package com.digivision.Multi_tenant_Property_Rent.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.digivision.Multi_tenant_Property_Rent.dto.PropertyDTO;
import com.digivision.Multi_tenant_Property_Rent.entity.Property;
import com.digivision.Multi_tenant_Property_Rent.service.RentService;

@RestController
@RequestMapping("/api/properties")
public class Controller {
    @Autowired
    RentService rentService;

    //http://localhost:9090/api/properties
    // {
    //    "title": "propertySeven",
    //    "owner_id": "airbnb"
    // }
    @PostMapping
    public ResponseEntity<Property> createProperty(@Valid @RequestBody PropertyDTO propertyDTO) {
        Property createdProperty = rentService.createProperty(propertyDTO);
        return ResponseEntity.ok(createdProperty);
    }

    //http://localhost:9090/api/properties
    @GetMapping
    public ResponseEntity<Page<Property>> getAllProperties(Pageable pageable) {
        return ResponseEntity.ok(rentService.getAllProperties(pageable));
    }


    //http://localhost:9090/api/properties/2
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(rentService.getPropertyById(id));
    }

    //http://localhost:9090/api/properties/6
    // {
    //    "title": "New_Value",
    //    "ownerId": "new_Owner"
    // }
    @PutMapping("/{id}")
    public int updateProperty(
            @PathVariable Long id,
            @Valid @RequestBody PropertyDTO propertyDTO) {
        return rentService.updateProperty(id, propertyDTO);
    }


    //http://localhost:9090/api/properties/8
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        rentService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}