package none.base;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="contact_tel_detail")
public class ContactTelDetail implements Serializable {
    private long id;
    private int version;
    private String telType;
    private String telNumber;
    private Contact contact;

    @ManyToOne
    @JoinColumn(name="CONTACT_ID")
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ContactTelDetail()
    {

    }

    public ContactTelDetail(String telType, String telNumber)
    {
        this.telNumber=telNumber;
        this.telType=telType;
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

    @Column(name="TEL_TYPE")
    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    @Column(name="TEL_NUMBER")
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
