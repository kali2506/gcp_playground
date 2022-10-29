package com.kali.app.BusinessLayer;

import java.util.List;
import java.util.Optional;

import com.kali.app.Entities.ToDoList;
import com.kali.app.PersistenceLayer.ToDoListRepositoryImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListServiceImpl implements ToDoListService{

    Logger logger = LoggerFactory.getLogger(ToDoListServiceImpl.class);

    @Autowired
    ToDoListRepositoryImpl toDoListRepositoryImpl;

    @Override
    public void saveToDo(ToDoList toDo) {
        toDoListRepositoryImpl.save(toDo);
    }

    @Override
    public void changeToDoState(ToDoList toDoList) {
        toDoListRepositoryImpl.save(toDoList);
        
    }

    @Override
    public void deleteToDo(String id) {
        toDoListRepositoryImpl.deleteById(id);
        
    }

    @Override
    public Optional<ToDoList> getToDo(String id) {
        Optional<ToDoList> toDo = null;
        if(id == null) {
            throw new NullPointerException();
        }
        toDo = toDoListRepositoryImpl.findById(id);
        return toDo;
    }

    @Override
    public List<ToDoList> getAllToDoForState(String status) {
        logger.info("Searching for Todos with state " +status);
        return toDoListRepositoryImpl.findAll();
    }
    
}
