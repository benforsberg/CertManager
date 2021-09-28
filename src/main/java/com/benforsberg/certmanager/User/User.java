package com.benforsberg.certmanager.User;

import com.benforsberg.certmanager.Cert.Cert;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String tags;
    private String phoneNum;
    private String pin;

    @OneToMany(mappedBy = "certOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cert> userCerts;

    public Set<Cert> getUserCerts() {
        return userCerts;
    }

    public void addUserCert(Cert cert) {
        userCerts.add(cert);
    }

    public void deleteUserCert(Cert cert) {
        userCerts.remove(cert);
    }

    public void setUserCerts(Set<Cert> userCerts) {
        this.userCerts = userCerts;
    }

    public User() {
        super();
    }

    public User( String firstName, String lastName, String tags, String phoneNum, String pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tags = tags;
        this.phoneNum = phoneNum;
        this.pin = pin;
    }

    public Set<Cert> printAllUserCerts(){
        return this.userCerts;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
