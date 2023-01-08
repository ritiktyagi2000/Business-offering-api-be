package com.springboot.offeringapi.service;

import com.springboot.offeringapi.entity.OfferingEntity;
import com.springboot.offeringapi.exception.BusinessException;
import com.springboot.offeringapi.exception.ErrorModel;
import com.springboot.offeringapi.mapper.OfferingMapper;
import com.springboot.offeringapi.model.OfferingModel;
import com.springboot.offeringapi.repository.OfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferingServiceImpl implements OfferingService {
    @Autowired
    OfferingRepository offeringRepository;

    @Override
    public boolean createOffering(OfferingModel offeringModel) {
        OfferingEntity offeringEntity = OfferingMapper.INSTANCE.convertModeltoEntity(offeringModel);
        OfferingEntity entity = offeringRepository.save(offeringEntity);
        if(entity!=null){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<OfferingModel> getAllOfferings() {
        List<OfferingModel>offeringModelList=new ArrayList<>();
        List<OfferingEntity> offeringEntities = offeringRepository.findAll();
        for(OfferingEntity offeringEntity:offeringEntities){
            OfferingModel offeringModel = OfferingMapper.INSTANCE.convertEntityToModel(offeringEntity);
            offeringModelList.add(offeringModel);
        }
        return offeringModelList;


    }

    @Override
    public OfferingModel getOfferingById(Long offeringId) throws BusinessException {
        Optional<OfferingEntity> offeringEntity = offeringRepository.findById(offeringId);
        OfferingModel offeringModel=new OfferingModel();
        if(offeringEntity.isPresent()){
          offeringModel = OfferingMapper.INSTANCE.convertEntityToModel(offeringEntity.get());

        }
        if(offeringEntity.isEmpty() || offeringEntity==null){
            ErrorModel errorModel=new ErrorModel();
            errorModel.setMessage("No offerings find by this id");
            errorModel.setCode("NOT_FOUND");
            List<ErrorModel>errorModelList=new ArrayList<>();
            throw new BusinessException(errorModelList);
        }
            return offeringModel;

    }
}
