package com.digivision.Multi_tenant_Property_Rent.service;

import com.digivision.Multi_tenant_Property_Rent.dto.PropertyDTO;
import com.digivision.Multi_tenant_Property_Rent.entity.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface RentService {
    Property getPropertyById(Long id);

    Page<Property> getAllProperties(Pageable pageable);

    int updateProperty(Long id, PropertyDTO propertyDTO);

    void deleteProperty(Long id);

    Property createProperty(PropertyDTO propertyDTO);
}
