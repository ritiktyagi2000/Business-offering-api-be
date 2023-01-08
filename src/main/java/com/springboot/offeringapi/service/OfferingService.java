package com.springboot.offeringapi.service;

import com.springboot.offeringapi.exception.BusinessException;
import com.springboot.offeringapi.model.OfferingModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferingService {
public boolean createOffering(OfferingModel offeringModel);
public List<OfferingModel> getAllOfferings();

    OfferingModel getOfferingById(Long offeringId) throws BusinessException;
}
