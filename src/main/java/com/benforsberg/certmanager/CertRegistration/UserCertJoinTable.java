package com.benforsberg.certmanager.CertRegistration;

import com.benforsberg.certmanager.User.*;
import com.benforsberg.certmanager.Cert.*;

import javax.persistence.*;

//Modeled after 3.3 CourseRating class
@Entity
public class UserCertJoinTable {
    @EmbeddedId
    CertRegistrationKey id;

    @ManyToOne
    @MapsId("userID")
    @JoinColumn(name= "user_id")
    User user;

    @ManyToOne
    @MapsId("certID")
    @JoinColumn(name = "cert_id")
    Cert cert;


}
