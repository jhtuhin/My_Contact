package com.jhtuhin.mycontact.models;

import com.jhtuhin.mycontact.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TheContact implements Serializable {
    private String name;
   final private String mobile;
   final private String email;
   final private String streetAddress;
   final private int image;

    public TheContact(String name, String mobile, String email, String streetAddress, int image) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.streetAddress = streetAddress;
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public int getImage() {
        return image;
    }


    public static List<TheContact> getAllContact(){
        List<TheContact> theContacts=new ArrayList<>();
        theContacts.add(new TheContact("Dan","0129383413","dan@gmail.com","34 Velocity park",R.drawable.dan));
        theContacts.add(new TheContact("Ron","0127654319","ron@gmail.com","76 Northern park",R.drawable.ron));
        theContacts.add(new TheContact("Leo","0129398643","leo@gmail.com","41 East Market",R.drawable.leo));
        theContacts.add(new TheContact("Ben","0129898761","ben@gmail.com","N20 Main Street",R.drawable.ben));
        theContacts.add(new TheContact("Bill","0128760984","bill@gmail.com","12 Village Root",R.drawable.bill));

        return theContacts;
    }
}
