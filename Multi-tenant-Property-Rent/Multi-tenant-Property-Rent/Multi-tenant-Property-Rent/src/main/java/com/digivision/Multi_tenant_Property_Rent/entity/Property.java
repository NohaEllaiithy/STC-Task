package com.digivision.Multi_tenant_Property_Rent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "owner_id")
    private String ownerId;
}
