package ua.kiev.prog;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Contacts")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    private String name;
    private String surname;
    private String phone;
    private String email;

    public Contact() {}

    public Contact(Group group, String name, String surname, String phone, String email) {
        this.group = group;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

   @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Contact contact)) return false;
        return Objects.equals(getId(), contact.getId()) && Objects.equals(getGroup(), contact.getGroup()) && Objects.equals(getName(),
                contact.getName()) && Objects.equals(getSurname(), contact.getSurname()) && Objects.equals(getPhone(),
                contact.getPhone()) && Objects.equals(getEmail(), contact.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGroup(), getName(), getSurname(), getPhone(), getEmail());
    }
}
