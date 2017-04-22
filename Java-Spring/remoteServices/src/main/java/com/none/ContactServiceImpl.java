package com.none;

import com.google.common.collect.Lists;
import com.none.Contact;
import com.none.ContactRepository;
import com.none.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired()
    private ContactRepository contactRepository;

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<Contact> findByFirstName(String firstName) {
        return Lists.newArrayList(contactRepository.findByFirstName(firstName));
    }

    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }
}
