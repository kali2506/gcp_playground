package com.kali.app.BusinessLayer;

import java.util.List;
import java.util.Optional;

import com.kali.app.Entities.Alina;
import com.kali.app.PersistenceLayer.AlinaRepositoryImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlinaServiceImpl implements AlinaService {

    @Autowired
    AlinaRepositoryImpl alinaRepositoryImpl;
    Logger logger = LoggerFactory.getLogger(AlinaServiceImpl.class);

    @Override
    public void saveAlina(Alina alina) {
        logger.debug("Saving Data");
        alinaRepositoryImpl.save(alina);       
    }

    @Override
    public Optional<Alina> getAlina(String id) {
        Optional<Alina> alina = null;
        alina = alinaRepositoryImpl.findById(id);
        logger.debug("Getting Data for id "+id);
        return alina;
    }

    @Override
    public List<Alina> getAll() {
        return alinaRepositoryImpl.findAll();
    }
    
}
