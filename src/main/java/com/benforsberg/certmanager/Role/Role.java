package com.benforsberg.certmanager.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;
    private String roleName;
    private boolean isAdmin;
    private String personID;

    public Role() {
    }

    public Role(long id, String roleName, boolean isAdmin, String personID) {
        this.id = id;
        this.roleName = roleName;
        this.isAdmin = isAdmin;
        this.personID = personID;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String roleMembers) {
        this.personID = roleMembers;
    }
}
