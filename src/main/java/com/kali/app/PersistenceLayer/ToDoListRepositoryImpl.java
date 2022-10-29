package com.kali.app.PersistenceLayer;

import com.kali.app.Entities.ToDoList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepositoryImpl extends MongoRepository<ToDoList, String>{
    
}
