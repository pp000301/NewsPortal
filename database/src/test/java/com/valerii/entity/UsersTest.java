package com.valerii.entity;

import lombok.Cleanup;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import java.io.Serializable;
import static org.junit.Assert.assertNotNull;

public class UsersTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void close() {
        FACTORY.close();
    }

    @org.junit.Test
    public void acheckSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            com.valerii.entity.Users user = new Users();
            Serializable id = session.save(user);
            assertNotNull(id);
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void getEntity(){
        @Cleanup Session session = FACTORY.openSession();
        val user= new com.valerii.entity.Users();
        Serializable id = session.save(user);
        assertNotNull(id);
        com.valerii.entity.Users test = session.get(com.valerii.entity.Users.class, id);
        assertNotNull(test);
    }
}