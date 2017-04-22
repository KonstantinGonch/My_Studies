package com.none;

import javax.persistence.*;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @PersistenceContext
    EntityManager em = emf.createEntityManager();

    public Person save(Person p) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        return p;
    }

    public void delete(Person p) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(p);
        tx.commit();

    }

    public List<Person> findAll() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }
}
