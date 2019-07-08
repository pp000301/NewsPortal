package com.valerii;

import com.valerii.dao.AutorDao;
import com.valerii.entity.Autor;

import java.util.ArrayList;
import java.util.List;

public class AutorServise {

    private static final AutorServise ourInstance = new AutorServise();
    private final AutorDao autorDao = AutorDao.getInstance();

    public List<Autor> getAllAutors(){
        List<Autor> autors = new ArrayList<>();
        autors=autorDao.GetAllAutor();
        return autors;
    }

    public static AutorServise getInstance() {
        return ourInstance;
    }
}
