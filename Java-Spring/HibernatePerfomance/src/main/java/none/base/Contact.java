package none.base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({@NamedQuery(name="Contact.findAllWithDetail", query = "select distinct  c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h"
)})
@Table(name="contact")
public class Contact implements Serializable {
    private long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Set<ContactTelDetail> constactTelDetails = new HashSet<ContactTelDetail>();
    private Set<Hobby> hobbies = new HashSet<Hobby>();

    @ManyToMany
    @JoinTable(name="contact_tel_detail", joinColumns = @JoinColumn(name="CONTACT_ID"), inverseJoinColumns = @JoinColumn(name="HOBBY_ID"))
    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ContactTelDetail> getConstactTelDetails() {
        return constactTelDetails;
    }

    public void setConstactTelDetails(Set<ContactTelDetail> constactTelDetails) {
        this.constactTelDetails = constactTelDetails;
    }

    public void addContactTElDetail(ContactTelDetail contactTelDetail)
    {
        contactTelDetail.setContact(this);
        getConstactTelDetails().add(contactTelDetail);
    }

    public void removeContactTelDetail(ContactTelDetail contactTelDetail)
    {
        getConstactTelDetails().remove(contactTelDetail);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString()
    {
        return "Contact - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
