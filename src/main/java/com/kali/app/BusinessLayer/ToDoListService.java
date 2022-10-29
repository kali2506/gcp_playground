package com.kali.app.BusinessLayer;

import java.util.List;
import java.util.Optional;

import com.kali.app.Entities.ToDoList;

public interface ToDoListService {

    public void saveToDo(ToDoList toDo);

    public void changeToDoState(ToDoList toDoList);

    public void deleteToDo(String toDoName);

    public Optional<ToDoList> getToDo(String toDoName);

    public List<ToDoList> getAllToDoForState(String status);
    
}
