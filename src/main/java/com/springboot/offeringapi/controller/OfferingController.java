package com.springboot.offeringapi.controller;

import com.springboot.offeringapi.exception.BusinessException;
import com.springboot.offeringapi.model.OfferingModel;
import com.springboot.offeringapi.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OfferingController {
    @Autowired
    OfferingService offeringService;
    @GetMapping("/get/offerings")
    public ResponseEntity<List<OfferingModel>>getAllOfferings(){

        List<OfferingModel> offerings = offeringService.getAllOfferings();
        return new ResponseEntity<>(offerings, HttpStatus.OK);

    }
    @GetMapping("/get/offering/{offeringId}")
    public ResponseEntity<OfferingModel>getOfferingById(@PathVariable Long offeringId ) throws BusinessException {
        OfferingModel offerings = offeringService.getOfferingById(offeringId);
        return new ResponseEntity<>(offerings, HttpStatus.OK);

    }
    @PostMapping("/create/offerings")
    public ResponseEntity<String>createOfferings(@RequestBody OfferingModel offeringModel){
        boolean result = offeringService.createOffering(offeringModel);

        if(result==true){
            return new ResponseEntity<>("Successfully create offering",HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("could not create offering",HttpStatus.BAD_REQUEST);
        }

    }


}
