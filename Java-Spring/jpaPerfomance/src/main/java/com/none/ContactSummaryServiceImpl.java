package com.none;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("contactSummaryService")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {
    @PersistenceContext
    private EntityManager em;

    public List<ContactSummary> findAll() {
        List<ContactSummary> result = em.createQuery("select new com.none.ContactSummary(c.firstName, c.lastName, t.telNumber ) " +
                "from Contact c left join c.contactTelDetails t where t.telType='Home'", ContactSummary.class).getResultList();
        return result;
    }
}
