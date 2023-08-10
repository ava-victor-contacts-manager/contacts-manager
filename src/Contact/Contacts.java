package Contact;

import java.util.ArrayList;

public class Contacts {
    // instance variables
    private String name;
    private String phoneNumber;

    //getters
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // constructor
    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return this.name + " " + this.phoneNumber;
    }
}
