package com.valerii.entity;

import lombok.Cleanup;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import java.io.Serializable;
import static org.junit.Assert.assertNotNull;

public class NewsTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void close() {
        FACTORY.close();
    }

    @org.junit.Test
    public void acheckSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            com.valerii.entity.News news = new News();
            Serializable id = session.save(news);
            assertNotNull(id);
            System.out.println(news);
        }
    }

    @org.junit.Test
    public void getEntity(){
        @Cleanup Session session = FACTORY.openSession();
        val news= new com.valerii.entity.News();
        Serializable id = session.save(news);
        assertNotNull(id);
        com.valerii.entity.News test = session.get(com.valerii.entity.News.class, id);
        assertNotNull(test);
    }

}