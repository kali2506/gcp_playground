package com.kali.app.PresentationLayer;

import java.util.List;

import com.kali.app.BusinessLayer.ToDoListServiceImpl;
import com.kali.app.Entities.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

    @Autowired
    ToDoListServiceImpl toDoListServiceImpl;

    @GetMapping(value = "/toDo", produces = {"application/json"})
    public ResponseEntity<List<ToDoList>> getToDo(@RequestParam String status) {
        List<ToDoList> toDoLists = toDoListServiceImpl.getAllToDoForState(status);
        return ResponseEntity.ok(toDoLists);
    }

    @PostMapping(value = "/saveToDo", consumes = {"application/json"})
    public ResponseEntity<String> saveToDo(@RequestBody ToDoList toDoList) {
        toDoListServiceImpl.saveToDo(toDoList);
        return ResponseEntity.ok("Successfully Saved");
    }

    @PutMapping(value = "/updateToDo") 
    public ResponseEntity<String> updateToDo(@RequestBody ToDoList toDoList) {
        toDoListServiceImpl.changeToDoState(toDoList);
        return ResponseEntity.ok("Successfully updated");
    }
    
}
