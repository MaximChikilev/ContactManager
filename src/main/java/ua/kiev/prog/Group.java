package ua.kiev.prog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Groups1")
public class Group {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy="group", cascade=CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<Contact>();

    public Group() {}

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public void addContactToGroup(Contact contact){
        if(!contacts.contains(contact)) contacts.add(contact);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Group group)) return false;
        return Objects.equals(getName(), group.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
