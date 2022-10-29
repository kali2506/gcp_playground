package com.kali.app.Entities;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

public class Alina {

    @Id
    String id;
    String name;
    String nachname;
    int age;
    LocalDate birthday;

    public Alina(String id, String name, String nachname, int age, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.nachname = nachname;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public String getNachname() {
        return this.nachname;
    }

    public int getAge() {
        return this.age;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }
    
}
