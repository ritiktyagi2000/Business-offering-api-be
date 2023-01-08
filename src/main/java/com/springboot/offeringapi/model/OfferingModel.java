package com.springboot.offeringapi.model;

import lombok.Data;

@Data
public class OfferingModel {
    private Long offeringId;
    private String offering;
    private String description;
    private String eligibilityCriteria;
}
