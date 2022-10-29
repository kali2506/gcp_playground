package com.kali.app.Entities;

import org.springframework.data.annotation.Id;

public class ToDoList {

    @Id
    String id;
    String toDo;
    String status;

    public ToDoList(String id, String toDo, String status) {
        this.id = id;
        this.toDo = toDo;
        this.status = status;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }  
}
