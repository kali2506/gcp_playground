package com.kali.app.PresentationLayer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.kali.app.BusinessLayer.AlinaServiceImpl;
import com.kali.app.Entities.Alina;
import com.mongodb.assertions.Assertions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    public static Logger logger = LoggerFactory.getLogger("AppController");
    AlinaServiceImpl aServiceImpl;

    public AppController(AlinaServiceImpl aServiceImpl) {
        this.aServiceImpl = aServiceImpl;
    }

    @GetMapping("/first")
    public void postAlina(@RequestParam(name = "id") String id, @RequestParam(name = "vorname") String name, @RequestParam(name = "nachname") String nachname, @RequestParam(name = "age") int age) {
        logger.info("TestEndpoint found :)");
        Assert.isTrue(age > 0, "Age must be positive");
        aServiceImpl.saveAlina(new Alina(id, name, nachname, age, LocalDate.of(1987, 6, 25)));
        logger.debug(aServiceImpl.getAlina(id).get().getName());
    }

    @GetMapping("/first/{id}")
    public List<Alina> firstTest(@PathVariable String id) {
        List<Alina> alina = aServiceImpl.getAll();
        if (alina == null) {
            logger.info("Nothing found");
        } else {
           for (Alina al : alina) {
               logger.info(al.getNachname());
           }
        }
        Assertions.assertNotNull(alina);
        logger.info("TestEndpoint found :)");
        return alina;
    }

    @PostMapping( value = "/save", consumes = {"application/json"})
    public String saveSingleAlina(@RequestBody Alina alina) {
        aServiceImpl.saveAlina(alina);
        return "Ok";
    }

    @GetMapping( value ="/gettingData", produces = {"application/json"})
    public ResponseEntity<Alina> getData(@RequestParam String id ) {
        Optional<Alina> alina = aServiceImpl.getAlina(id);
        return ResponseEntity.of(alina);
    }
    
}
