package com.benforsberg.certmanager.User;

import com.benforsberg.certmanager.Cert.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isAdmin;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Cert> certs;

    public User() {
        //this.certs = certs;
        this.firstName = "John";
        this.lastName = "Doe";
        this.email = "john@doe.com";
        this.isAdmin = false;

    }

    public User(String firstName, String lastName, String email, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isAdmin = isAdmin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Set<Cert> getCerts() {
        return certs;
    }

    public void setCerts(Set<Cert> certs) {
        this.certs = certs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdmin == user.isAdmin && getId().equals(user.getId()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getEmail().equals(user.getEmail()) && Objects.equals(getCerts(), user.getCerts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), isAdmin, getCerts());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", certs=" + certs +
                '}';
    }
}

