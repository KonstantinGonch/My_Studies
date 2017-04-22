package com.none;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return contacts;
    }

    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        List<Contact> contacts = em.createNamedQuery("contact.findAllWithDetail", Contact.class).getResultList();
        return contacts;
    }

    @Transactional(readOnly = true)
    public Contact findById(long id) {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public Contact save(Contact contact) {
        if (contact.getId()==0)
        {
            em.persist(contact);
        }
        else
        {
            em.merge(contact);
        }
        return contact;
    }

    public void delete(Contact contact) {
        em.remove(contact);
    }

    public List<Contact> findAllByNativeQuery() {
        final String QUERY= "SELECT id, first_name, last_name, birth_date, version FROM contact";
        return em.createNativeQuery(QUERY, Contact.class).getResultList();
    }
}
