package com.valerii.entity;

import lombok.Cleanup;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import java.io.Serializable;
import static org.junit.Assert.assertNotNull;

public class CommentsTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void close() {
        FACTORY.close();
    }

    @org.junit.Test
    public void acheckSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            com.valerii.entity.Comments comment = new Comments();
            Serializable id = session.save(comment);
            assertNotNull(id);
            System.out.println(comment);
        }
    }

    @org.junit.Test
    public void getEntity(){
        @Cleanup Session session = FACTORY.openSession();
        val comment= new com.valerii.entity.Comments();
        Serializable id = session.save(comment);
        assertNotNull(id);
        com.valerii.entity.Comments test = session.get(com.valerii.entity.Comments.class, id);
        assertNotNull(test);
    }

}