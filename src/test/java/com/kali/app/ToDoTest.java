package com.kali.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.kali.app.BusinessLayer.AlinaServiceImpl;
import com.kali.app.BusinessLayer.ToDoListServiceImpl;
import com.kali.app.Entities.Alina;
import com.kali.app.Entities.ToDoList;
import com.kali.app.PersistenceLayer.AlinaRepositoryImpl;
import com.kali.app.PersistenceLayer.ToDoListRepositoryImpl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;


@SpringBootTest
public class ToDoTest {

    @MockBean
    AlinaRepositoryImpl alinaRepositoryImpl;
    @MockBean
    ToDoListRepositoryImpl toDoListRepositoryImpl;

    @SpyBean
    AlinaServiceImpl alinaServiceImpl;
    @SpyBean
    ToDoListServiceImpl toDoListService;

    @Test
    public void firstTest() {
       String result = readFileInput();
       System.out.println(result.contains("_id"));
       assertAll(
            () -> assertTrue("Test1 :should be true", true  ),
            () -> assertFalse("Test2 :should be false",false),
            () -> assertFalse("Test3 :should be false", false),
            () -> assertFalse("Test4 :should be false", false)
    );
    }

    @Test
    public void firstMockTest() {
        Alina alina = new Alina("", "", "", 1, LocalDate.of(2022, 2, 1));
        Mockito.when(alinaRepositoryImpl.save(any(Alina.class))).thenReturn(alina);
        alinaServiceImpl.saveAlina(alina);
        System.out.println("firstmock");
    }

    @Test
    public void toDoListTest() {
        List<ToDoList> toDoListe = prepareList();
        Mockito.when(toDoListRepositoryImpl.findAll()).thenReturn(toDoListe);
        List<ToDoList> res = toDoListService.getAllToDoForState("open");
        for(ToDoList el : res) {
            System.out.println(el.getId()+" "+el.getToDo());
        }
        assertThrows(NullPointerException.class, () -> toDoListService.getToDo(null));
        assertNotNull(res);
        assertEquals(res.get(0).getId(), "1");
        assertEquals(res.size(), 2);
       
    }

    private List<ToDoList> prepareList() {
        ToDoList liste = new ToDoList("1", "lesen", "open");
        ToDoList liste1 = new ToDoList("2", "schreiben", "closed");
        ToDoList liste2 = new ToDoList("3", "schlafen", "open");
        List<ToDoList> list = new ArrayList<>();
        list.add(liste);
        list.add(liste1);
        list.add(liste2);
        list.removeIf(el-> !el.getStatus().equals("open"));
        return list;
    }

    public String readFileInput() {
        
        InputStream resourceAsStream = getClass().getResourceAsStream("/toDoTest.json");
        StringBuilder input = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream))) {
            String line;
            while((line = reader.readLine()) != null) {
                input.append(line);
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return input.toString();
     }
}
