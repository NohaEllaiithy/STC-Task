package com.digivision.Multi_tenant_Property_Rent.entity;

import lombok.Data;
import jakarta.persistence.*;


@Entity
@Data
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(nullable = false)
    private String name;

}

