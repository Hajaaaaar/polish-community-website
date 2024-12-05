package com.example.polishCommunity.service;

import com.example.polishCommunity.model.Rights;
import com.example.polishCommunity.repository.RightsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RightsService {


    private RightsRepo rightsRepo;
    public RightsService(RightsRepo rightsRepo){
        this.rightsRepo=rightsRepo;
 }
        public Rights getRightsByTitleId(int id){
        Rights rights = rightsRepo.getRightsById(id);
        rights.setSubTitle(rightsRepo.getSubRightsByRightsId(id));
        rights.setQue(rightsRepo.getRightsFAQsByRightsId(id));
        return rights;
        }


}
