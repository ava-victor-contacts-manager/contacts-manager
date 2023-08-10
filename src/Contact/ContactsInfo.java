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
    private static Path p = Paths.get("src/Contact/contacts.txt");

    public static void main(String[] args) {

        Contacts bill = new Contacts("Billy Bob", "2103456784");
        Contacts sandy = new Contacts("Sandy Cheeks", "2103456784");
        Contacts tom = new Contacts("Tommy Tom", "2103456784");
        Contacts jill = new Contacts("Jill Joe", "2106783456");

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

            for(String text : lineOfTexts){
                System.out.println(text);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addNewContact() {
        Input input = new Input();
        System.out.println("Enter a name");
        String usersName = input.getString();
        System.out.println("Enter a phone number");
        String usersPhoneNumber = input.getString();
        Contacts newContact = new Contacts(usersName, usersPhoneNumber);
        contactList.add(newContact);
        try{
            Set<String> existingNames = new HashSet<>(Files.readAllLines(p));
            for (Contacts contacts : contactList) {
                if (!existingNames.contains(contacts.getName())) {
                    Files.write(p, Collections.singletonList(contacts.getName() + " " + contacts.getPhoneNumber()), StandardOpenOption.APPEND);
                    existingNames.add(contacts.getName());
}
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void searchContacts(){

    }

    public static void deleteContact() {

    }

}
