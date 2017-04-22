package none.base;

import java.util.List;

/**
 * Created by JohnCena on 03.04.2017.
 */
public interface ContactDAO {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
