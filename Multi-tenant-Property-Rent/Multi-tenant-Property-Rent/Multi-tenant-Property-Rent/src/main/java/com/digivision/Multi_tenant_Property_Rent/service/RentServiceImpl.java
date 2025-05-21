package com.digivision.Multi_tenant_Property_Rent.service;

import com.digivision.Multi_tenant_Property_Rent.dto.PropertyDTO;
import com.digivision.Multi_tenant_Property_Rent.entity.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.digivision.Multi_tenant_Property_Rent.repository.PropertyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService{

    private final PropertyRepository propertyRepository;

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findAllById(id);
    }

    @Override
    public Page<Property> getAllProperties(Pageable pageable) {
        return propertyRepository.findAll(pageable);
    }

    @Override
    public int updateProperty(Long id, PropertyDTO propertyDTO) {
        return propertyRepository.updateProperty(id,propertyDTO.getTitle(),propertyDTO.getOwnerId());
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public Property createProperty(PropertyDTO propertyDTO) {

        Property property = new Property();
        property.setTitle(propertyDTO.getTitle());
        property.setOwnerId(propertyDTO.getOwnerId());
        return propertyRepository.save(property);
    }
}
