package com.none;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Service("contactSummaryUntype")
public class ContactSummaryUntypeImpl {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
            public void displayAllContactSummary()
    {
        List result = em.createQuery("select c.firstName, c.lastName, t.telNumber from Contact c left join c.contactTelDetails t where t.telType='Home'")
                .getResultList();
        int count = 0;
        for(Iterator i = result.iterator(); i.hasNext();)
        {
            Object[] values = (Object[]) i.next();
            System.out.println(++count+": "+values[0]+", "+values[1]+", "+values[2]);
        }
    }
}
