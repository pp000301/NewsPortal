package com.valerii.entity;

import lombok.Cleanup;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import java.io.Serializable;
import static org.junit.Assert.assertNotNull;

public class AutorTest {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void close() {
        FACTORY.close();
    }

    @org.junit.Test
    public void acheckSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            com.valerii.entity.Autor petr = new Autor();
            Serializable id = session.save(petr);
            assertNotNull(id);
            System.out.println(petr);
        }
    }

    @org.junit.Test
    public void getEntity(){
        @Cleanup Session session = FACTORY.openSession();
        val sveta= new com.valerii.entity.Autor();
        Serializable id = session.save(sveta);
        assertNotNull(id);
        com.valerii.entity.Autor test = session.get(com.valerii.entity.Autor.class, id);
        assertNotNull(test);
    }

}