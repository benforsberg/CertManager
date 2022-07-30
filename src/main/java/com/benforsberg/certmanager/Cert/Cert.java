package com.benforsberg.certmanager.Cert;


import com.benforsberg.certmanager.User.User;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    public int daysUntilExpired;
    private boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Cert(String certExpiration, String certIssuer, String certType, String certDescription, String certCode, String certLength, User user) {
        this.certExpiration = certExpiration;
        this.certIssuer = certIssuer;
        this.certType = certType;
        this.certDescription = certDescription;
        this.certCode = certCode;
        this.certLength = certLength;
        this.isExpired = calcIsCertExpired(parseDateFromString(certExpiration));//isExpired;
        this.daysUntilExpired = calcDaysUntilExpired(parseDateFromString(certExpiration));
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

    public int getDaysUntilExpired() {
        return calcDaysUntilExpired(parseDateFromString(certExpiration));
    }

    public void setDaysUntilExpired(int daysUntilExpired) {
        this.daysUntilExpired = daysUntilExpired;
    }

    //Helper methods for cert
    public LocalDate parseDateFromString(String certExpiration){
        LocalDate expirationDate = LocalDate.parse(certExpiration);
        return expirationDate;

    }

    public boolean calcIsCertExpired(LocalDate expirationDate){
//        LocalDate date = expirationDate;
//        LocalDate today = LocalDate.now();
//
//        if (date.isBefore(today) || date.isEqual(today))
//            return true;

        int days = calcDaysUntilExpired(expirationDate);
        if (days <= 0) {
            return true;
        } else return false;

    }

    public int calcDaysUntilExpired(LocalDate expirationDate){
        LocalDate today = LocalDate.now();

        long daysUntilExpires = ChronoUnit.DAYS.between(today, expirationDate);

        return (int)daysUntilExpires;

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
                ", daysUntilExpired=" + daysUntilExpired +
                ", isExpired=" + isExpired +
                ", user=" + user +
                '}';
    }
}
