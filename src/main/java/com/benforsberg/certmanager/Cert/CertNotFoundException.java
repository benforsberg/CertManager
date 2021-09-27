package com.benforsberg.certmanager.Cert;

public class CertNotFoundException extends RuntimeException{
    public CertNotFoundException(String exception){
        super(exception);
    }
}
