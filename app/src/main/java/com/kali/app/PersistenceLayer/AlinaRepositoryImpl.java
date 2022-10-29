package com.kali.app.PersistenceLayer;

import java.util.Optional;
import com.kali.app.Entities.Alina;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlinaRepositoryImpl extends MongoRepository<Alina, String>{

    public Optional<Alina> findById(String id);

    public Optional<Alina> findByName(String name);
    
}
