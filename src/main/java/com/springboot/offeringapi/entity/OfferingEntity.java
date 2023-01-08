package com.springboot.offeringapi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "business_offering_table")
@Data
public class OfferingEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offeringId;
   @Column(nullable = false,length = 50)
   private String offering;
    private String description;
    private String eligibilityCriteria;
}
