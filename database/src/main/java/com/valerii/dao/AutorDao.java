package com.valerii.dao;

import com.valerii.entity.Autor;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDao {
    private static AutorDao ourInstance = new AutorDao();

    public static AutorDao getInstance() {
        return ourInstance;
    }

    public List<Autor> GetAllAutor(){
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        Query<Autor> quary = session.createQuery("select a from Autor a", Autor.class);
        List<Autor> autors = quary.list();
        return autors;
    }

}
