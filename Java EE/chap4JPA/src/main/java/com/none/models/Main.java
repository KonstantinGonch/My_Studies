package com.none.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by JohnCena on 17.04.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        Book book = new Book("H2G2", 12.5F, "Автостопом по галактике", "1-84023-742-2", 354, false);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NNN");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
        emf.close();
    }
}
