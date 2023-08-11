package Contact;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsInfo {

    //Global
    private static ArrayList<Contacts> contactList =  readFromFile();
    private static final Path path = Paths.get("src/Contact/contacts.txt");
    private static final Input input = new Input();


    //main methods
    public static void main(String[] args) {
        execute();
    }

    //methods
    public static ArrayList<Contacts> readFromFile(){
    ArrayList<String> contacts = new ArrayList<>();
    ArrayList<Contacts> newList = new ArrayList<>();
    Path path = Paths.get("src/Contact/contacts.txt");

        try {
            contacts = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (String contact: contacts) {
            String[] arr = contact.split(",");
            Contacts newGuy = new Contacts(arr[0], arr[1]);
            newList.add(newGuy);
        }
        return newList;
    }
    public static void execute() {
        // write a method that reads all lines from the file
        // converts from strings to Contacts objects
        // adds the Contacts objects to the contactList ArrayList


        while (true) {

            Input input = new Input();
            System.out.println("1. View contacts.\n2. Add a new contact. \n3. Search a contact by name. \n4. Delete an existing contact. \n5. Exit.\nEnter an option (1, 2, 3, 4 or 5):");
            int usersInput = input.getInt();
            if (usersInput == 1) {
                showAllContacts();
            } else if (usersInput == 2) {
                addNewContact();
            } else if (usersInput == 3) {
                System.out.println(searchContacts());
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
            Set<String> existingNames = new HashSet<>(Files.readAllLines(path));
                if (!existingNames.contains(newContact.getName())) {
                    Files.write(path, Collections.singletonList(newContact.getName() + "," + newContact.getPhoneNumber()), StandardOpenOption.APPEND);
                    existingNames.add(newContact.getName());
                    contactList.add(newContact);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String searchContacts() {
        System.out.println("Who would you like to search for?");
        String usersSearch = input.getString();
        for(Contacts contact : contactList) {
            if(contact.getName().contains(usersSearch)){
                return contact.toString();
            }
        }
        return "user not found";
    }
    public static void deleteContact() {
        System.out.println("Which contact would you like to Delete?\n");
        String deleteUser = input.getString();
    }

}
