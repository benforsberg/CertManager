package com.benforsberg.certmanager.Cert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cert {

    @Id
    @GeneratedValue
    //@Column(name="id")
    private Long id;
    //Set to ID of person who owns cert
    private String certOwner;
    private String certExpiration;
    private String certIssuer;
    private String certType;
    private String certDescription;
    private String certCode;
    private String certLength;
    private boolean certIsExpired;

    public Cert(Long id, String certOwner, String certExpiration, String certIssuer, String certType, String certDescription, String certCode, String certLength, boolean certIsExpired) {
        this.id = id;
        this.certOwner = certOwner;
        this.certExpiration = certExpiration;
        this.certIssuer = certIssuer;
        this.certType = certType;
        this.certDescription = certDescription;
        this.certCode = certCode;
        this.certLength = certLength;
        this.certIsExpired = certIsExpired;
    }

    public Cert() {
        this.id = 15l;
        this.certOwner = "Ben Forsberg";
        this.certExpiration = "October 12, 2021";
        this.certIssuer = "American Red Cross";
        this.certType = "Instructor";
        this.certDescription = "Lifeguard Instructor";
        this.certCode = "GT4FB3";
        this.certLength = "2 Years";
        this.certIsExpired = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertOwner() {
        return certOwner;
    }

    public void setCertOwner(String shiftOwner) {
        this.certOwner = shiftOwner;
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

    public boolean isCertIsExpired() {
        return certIsExpired;
    }

    public void setCertIsExpired(boolean certIsExpired) {
        this.certIsExpired = certIsExpired;
    }


    public boolean getCertIsExpired() {
        return this.certIsExpired;
    }

    public void setCertIsExpired(String shiftRole) {
        this.certIsExpired = certIsExpired;
    }
}
