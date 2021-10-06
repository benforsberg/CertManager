package com.benforsberg.certmanager.Cert;

import com.benforsberg.certmanager.CertRegistration.CertRegistration;
import com.benforsberg.certmanager.CertRegistration.UserCertJoinTable;
import com.benforsberg.certmanager.User.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cert {

    @Id
    @GeneratedValue
    //@Column(name="id")
    private Long id;
    //Set to ID of person who owns cert
    private String certExpiration;
    private String certIssuer;
    private String certType;
    private String certDescription;
    private String certCode;
    private String certLength;
    private boolean certIsExpired;

    @ManyToMany(mappedBy = "userCerts")
    Set<User> certOwner;

    @OneToMany(mappedBy = "cert")
    Set<CertRegistration> certRegistrations;

    @OneToMany(mappedBy = "cert")
    Set<UserCertJoinTable> userCertJoinTables;

    public Cert( String certExpiration, String certIssuer, String certType, String certDescription, String certCode, String certLength, boolean certIsExpired) {
        this.certExpiration = certExpiration;
        this.certIssuer = certIssuer;
        this.certType = certType;
        this.certDescription = certDescription;
        this.certCode = certCode;
        this.certLength = certLength;
        this.certIsExpired = certIsExpired;
    }

    public Cert() {
        this.certExpiration = "October 12, 2021";
        this.certIssuer = "American Red Cross";
        this.certType = "Instructor";
        this.certDescription = "Lifeguard Instructor";
        this.certCode = "GT4FB3";
        this.certLength = "2 Years";
        this.certIsExpired = false;
        this.certOwner = null;
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

    public String toString(){
        return "Certcode: " + this.certCode + " | Owner: "  + this.certOwner + " | Issuer: " + this.certIssuer + " | Type: " + this.certType + " | Description: " + this.certDescription + " ||| ";
    }
}
