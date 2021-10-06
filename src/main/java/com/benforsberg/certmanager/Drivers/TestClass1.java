package com.benforsberg.certmanager.Drivers;

import com.benforsberg.certmanager.*;
import com.benforsberg.certmanager.Cert.Cert;
import com.benforsberg.certmanager.User.User;

import java.util.ArrayList;
import java.util.List;


public class TestClass1 {
    public TestClass1(){
    }

    public String Driver() {

        ArrayList<User> userList = new ArrayList<User>();
        User ben = new User("Ben","Forsberg", "Admin", "9517608320", "6829");
        userList.add(new User("Ben","Forsberg", "Admin", "9517608320", "6829"));
        userList.add(new User("Jake","Forsberg", "User", "1234567890", "2265"));

        List<Cert> certList = new ArrayList<Cert>();
        Cert benWSICert = new Cert("June 2022", "Red Cross", "Instructor", "Water Safety Instructor",
                "HTb45F", "2 Years", false);

        certList.add(new Cert());
        certList.add(benWSICert);

        String output = certList.toString();
        System.out.println("Output " + output);
        return output;
    }

}
