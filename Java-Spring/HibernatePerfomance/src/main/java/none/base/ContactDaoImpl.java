package none.base;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by JohnCena on 03.04.2017.
 */
@Transactional
public class ContactDaoImpl implements ContactDAO {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
    }

    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        return sessionFactory.getCurrentSession().
                getNamedQuery("Contact.findAllWithDetail") .list();
    }

    public Contact findById(long id) {
        return null;
    }

    public Contact save(Contact contact) {
        return null;
    }

    public void delete(Contact contact) {

    }
}
