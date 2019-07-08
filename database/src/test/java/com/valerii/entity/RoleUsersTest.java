package com.valerii.entity;

import lombok.Cleanup;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import java.io.Serializable;
import static org.junit.Assert.assertNotNull;

public class RoleUsersTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void close() {
        FACTORY.close();
    }

    @org.junit.Test
    public void acheckSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            com.valerii.entity.RoleUsers roleUsers = new RoleUsers();
            Serializable id = session.save(roleUsers);
            assertNotNull(id);
            System.out.println(roleUsers);
        }
    }

    @org.junit.Test
    public void getEntity(){
        @Cleanup Session session = FACTORY.openSession();
        val roleUsers= new com.valerii.entity.RoleUsers();
        Serializable id = session.save(roleUsers);
        assertNotNull(id);
        com.valerii.entity.RoleUsers test = session.get(com.valerii.entity.RoleUsers.class, id);
        assertNotNull(test);
    }

}