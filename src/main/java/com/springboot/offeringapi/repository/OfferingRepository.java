package com.springboot.offeringapi.repository;

import com.springboot.offeringapi.entity.OfferingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferingRepository extends JpaRepository<OfferingEntity,Long> {
}
