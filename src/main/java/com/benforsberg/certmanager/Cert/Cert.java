package com.benforsberg.certmanager.Cert;


import com.benforsberg.certmanager.User.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "certs")
public class Cert implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    //Set to ID of person who owns cert
    private String certExpiration;
    private String certIssuer;
    private String certType;
    private String certDescription;
    private String certCode;
    private String certLength;
    private boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Cert(String certExpiration, String certIssuer, String certType, String certDescription, String certCode, String certLength, boolean isExpired, User user) {
        this.certExpiration = certExpiration;
        this.certIssuer = certIssuer;
        this.certType = certType;
        this.certDescription = certDescription;
        this.certCode = certCode;
        this.certLength = certLength;
        this.isExpired = isExpired;
        this.user = user;
    }

    public Cert() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertExpiration() {
        return certExpiration;
    }

    public void setCertExpiration(String shiftDate) {
        this.certExpiration = shiftDate;
    }

    public String getCertIssuer() {
        return certIssuer;
    }

    public void setCertIssuer(String shiftStartTime) {
        this.certIssuer = shiftStartTime;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String shiftEndTime) {
        this.certType = shiftEndTime;
    }

    public String getCertDescription() {
        return certDescription;
    }

    public void setCertDescription(String shiftName) {
        this.certDescription = shiftName;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String shiftLocation) {
        this.certCode = shiftLocation;
    }

    public String getCertLength() {
        return certLength;
    }

    public void setCertLength(String certLength) {
        this.certLength = certLength;
    }

    public boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public Long getOwnerID() {
        return user.getId();
    }

    @Override
    public String toString() {
        return "Cert{" +
                "id=" + id +
                ", certExpiration='" + certExpiration + '\'' +
                ", certIssuer='" + certIssuer + '\'' +
                ", certType='" + certType + '\'' +
                ", certDescription='" + certDescription + '\'' +
                ", certCode='" + certCode + '\'' +
                ", certLength='" + certLength + '\'' +
                ", isExpired=" + isExpired +
                ", user=" + user +
                '}';
    }
}
