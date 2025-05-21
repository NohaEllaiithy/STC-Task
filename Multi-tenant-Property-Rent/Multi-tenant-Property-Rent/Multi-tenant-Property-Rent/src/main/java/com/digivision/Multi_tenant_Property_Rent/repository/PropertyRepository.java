package com.digivision.Multi_tenant_Property_Rent.repository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import com.digivision.Multi_tenant_Property_Rent.entity.Property;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PropertyRepository extends JpaRepository<Property, Long>{

    Property findAllById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE properties SET title = :title, owner_id = :ownerId WHERE id = :id", nativeQuery = true)
    int updateProperty(@Param("id") Long id, @Param("title") String title, @Param("ownerId") String ownerId);
}
