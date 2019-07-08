package com.valerii.entity;

import lombok.Cleanup;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import java.io.Serializable;
import static org.junit.Assert.assertNotNull;

public class Category_newsTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void close() {
        FACTORY.close();
    }

    @org.junit.Test
    public void acheckSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            com.valerii.entity.Category_news category_news = new Category_news();
            Serializable id = session.save(category_news);
            assertNotNull(id);
        }
    }

    @org.junit.Test
    public void getEntity(){
        @Cleanup Session session = FACTORY.openSession();
        val category_news= new com.valerii.entity.Category_news();
        Serializable id = session.save(category_news);
        assertNotNull(id);
        com.valerii.entity.Category_news test = session.get(com.valerii.entity.Category_news.class, id);
        assertNotNull(test);
    }

}