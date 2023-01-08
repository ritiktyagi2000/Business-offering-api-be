package com.springboot.offeringapi.mapper;

import com.springboot.offeringapi.entity.OfferingEntity;
import com.springboot.offeringapi.model.OfferingModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface OfferingMapper {
    OfferingMapper INSTANCE = Mappers.getMapper(OfferingMapper.class);

    OfferingModel convertEntityToModel(OfferingEntity offeringEntity);
    OfferingEntity convertModeltoEntity(OfferingModel offeringModel);
}

