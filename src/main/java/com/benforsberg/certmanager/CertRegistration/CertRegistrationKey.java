package com.benforsberg.certmanager.CertRegistration;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CertRegistrationKey implements Serializable {
    @Column(name = "user_id")
    Long userID;

    @Column(name = "cert_id")
    Long certID;



    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getCertID() {
        return certID;
    }

    public void setCertID(Long certID) {
        this.certID = certID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertRegistrationKey that = (CertRegistrationKey) o;
        return getUserID().equals(that.getUserID()) && getCertID().equals(that.getCertID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getCertID());
    }

    @Override
    public String toString() {
        return "CertRegistrationKey{" +
                "userID=" + userID +
                ", certID=" + certID +
                '}';
    }
}
