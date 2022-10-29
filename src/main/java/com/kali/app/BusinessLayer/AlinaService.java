package com.kali.app.BusinessLayer;

import java.util.Optional;
import java.util.*;

import com.kali.app.Entities.Alina;

public interface AlinaService {
    
    public void saveAlina(Alina alina);

    public Optional<Alina> getAlina(String id);

    public List<Alina> getAll();
}
