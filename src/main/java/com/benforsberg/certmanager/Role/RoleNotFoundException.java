package com.benforsberg.certmanager.Role;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String exception){
        super(exception);
    }
}
