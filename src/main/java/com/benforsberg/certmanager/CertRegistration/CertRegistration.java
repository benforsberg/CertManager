package com.benforsberg.certmanager.CertRegistration;

import com.benforsberg.certmanager.User.*;
import com.benforsberg.certmanager.Cert.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class CertRegistration {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "cert_id")
    Cert cert;

    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date lastModified = new Date(System.currentTimeMillis());
    String lastModifiedStr = formatter.format(lastModified).toString();

    Long lastModifiedbyUserID = user.getId();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cert getCert() {
        return cert;
    }

    public void setCert(Cert cert) {
        this.cert = cert;
    }

    public String getLastModifiedStr() {
        return lastModifiedStr;
    }

    public void setLastModifiedStr(String lastModifiedStr) {
        this.lastModifiedStr = lastModifiedStr;
    }

    public Long getLastModifiedbyUserID() {
        return lastModifiedbyUserID;
    }

    public void setLastModifiedbyUserID(Long lastModifiedbyUserID) {
        this.lastModifiedbyUserID = lastModifiedbyUserID;
    }
}
