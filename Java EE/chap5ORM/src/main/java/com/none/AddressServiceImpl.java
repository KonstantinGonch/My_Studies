package com.none;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by JohnCena on 19.04.2017.
 */
public class AddressServiceImpl implements AddressService{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    EntityManager em = emf.createEntityManager();

    public Job save(Job j) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(j);
        tx.commit();
        return j;
    }

    public void delete(Job j) {
        EntityTransaction tx= em.getTransaction();
        tx.begin();
        em.remove(j);
        tx.commit();
    }
}
