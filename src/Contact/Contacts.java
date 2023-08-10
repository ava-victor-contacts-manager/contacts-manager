package Contact;

import java.util.ArrayList;

public class Contacts {
    // instance variables
    private String name;
    private long phoneNumber;

    //getters
    public String getName() {
        return name;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // constructor
    public Contacts(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

}
