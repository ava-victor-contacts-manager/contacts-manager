package Contact;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.util.*;

public class ContactsInfo {

    private static ArrayList<Contacts> contactList = new ArrayList<>();
    private static final Path p = Paths.get("src/Contact/contacts.txt");
    private static final Input input = new Input();

    public static void main(String[] args) {
        execute();
    }

    //methods

    public static void execute() {
        while (true) {
            Input input = new Input();
            System.out.println("1. View contacts.\n2. Add a new contact. \n3. Search a contact by name. \n4. Delete an existing contact. \n5. Exit.\nEnter an option (1, 2, 3, 4 or 5):");
            int usersInput = input.getInt();
            if (usersInput == 1) {
                showAllContacts();
            } else if (usersInput == 2) {
                addNewContact();
            } else if (usersInput == 3) {
                searchContacts();
            } else if (usersInput == 4) {
                deleteContact();
            } else {
                break;
            }
        }
    }

    public static void showAllContacts() {
        try {
            List<String> lineOfTexts = Files.readAllLines(
                    Paths.get("src/Contact/contacts.txt")
            );

            for (String text : lineOfTexts) {
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewContact() {
        System.out.println("Enter a name");
        String usersName = input.getString();
        System.out.println("Enter a phone number");
        String usersPhoneNumber = input.getString();
        Contacts newContact = new Contacts(usersName, usersPhoneNumber);
        try {
            Set<String> existingNames = new HashSet<>(Files.readAllLines(p));
                if (!existingNames.contains(newContact.getName())) {
                    Files.write(p, Collections.singletonList(newContact.getName() + " " + newContact.getPhoneNumber()), StandardOpenOption.APPEND);
                    existingNames.add(newContact.getName());
                    contactList.add(newContact);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchContacts() {
        System.out.println("Who would you like to search for?");
        String usersSearch = input.getString();
        for(Contacts contact : contactList) {
            if(contact.getName().equalsIgnoreCase(usersSearch)){
                System.out.println(contact.getName());
                System.out.println(contact.getName() + " " + contact.getPhoneNumber());
            }
        }
    }

    public static void deleteContact() {

    }

}
