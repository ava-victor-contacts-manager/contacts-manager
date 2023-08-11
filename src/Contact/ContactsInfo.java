package Contact;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsInfo {

    //Global
    private static ArrayList<Contact> contactList = readFromFile();
    private static final Path path = Paths.get("src/Contact/contacts.txt");
    private static final Input input = new Input();


    //main methods
    public static void main(String[] args) {
        execute();
    }

    //methods
    public static ArrayList<Contact> readFromFile() {
        ArrayList<String> contacts = new ArrayList<>();
        ArrayList<Contact> newList = new ArrayList<>();
        Path path = Paths.get("src/Contact/contacts.txt");

        try {
            contacts = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String contact : contacts) {
            String[] arr = contact.split(",");
            Contact newGuy = new Contact(arr[0], arr[1]);
            newList.add(newGuy);
        }
        return newList;
    }
    public static void execute() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            Input input = new Input();
            System.out.println("1. View contacts.\n2. Add a new contact. \n3. Search a contact by name. \n4. Delete an existing contact. \n5. Exit.\nEnter an option (1, 2, 3, 4 or 5):");
            int usersInput = input.getInt();
            if (usersInput == 1) {
                showAllContacts();
                System.out.print("Do you want to continue? [y/n]: ");
                String userContinue = sc.next();
                if (userContinue.equalsIgnoreCase("y")) {
                } else {
                    writeToFile();
                    break;
                }
            } else if (usersInput == 2) {
                addNewContact();
                System.out.print("Do you want to continue? [y/n]: ");
                String userContinue = sc.next();
                if (userContinue.equalsIgnoreCase("y")) {
                } else {
                    writeToFile();
                    break;
                }
            } else if (usersInput == 3) {
                searchContacts();
                System.out.print("Do you want to continue? [y/n]: ");
                String userContinue = sc.next();
                if (userContinue.equalsIgnoreCase("y")) {
                } else {
                    writeToFile();
                    break;
                }
            } else if (usersInput == 4) {
                deleteContact();
                System.out.print("Do you want to continue? [y/n]: ");
                String userContinue = sc.next();
                if (userContinue.equalsIgnoreCase("y")) {
                } else {
                    writeToFile();
                    break;
                }
            } else {
                writeToFile();
                break;
            }
        }
    }
    public static void showAllContacts() {
        System.out.println(contactList.toString());
    }
    public static void addNewContact() {
        System.out.println("Enter a name");
        String usersName = input.getString();
        System.out.println("Enter a phone number");
        String usersPhoneNumber = input.getString();

        String formattedPhoneNumber = usersPhoneNumber.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        Contact tempContact = new Contact();
        Contact newContact = new Contact(usersName, formattedPhoneNumber);

        for (Contact contact : contactList) {
            if (!newContact.equals(contact)) {
                tempContact = newContact;
            }
        }
        contactList.add(tempContact);
    }
    public static String searchContacts() {
        System.out.println("Who would you like to search for?");
        String usersSearch = input.getString();
        for (Contact contact : contactList) {
            if (contact.getName().toLowerCase().contains(usersSearch)) {
                return contact.toString();
            }
        }
        return "user not found";
    }
    public static void deleteContact() {
        System.out.println("Which contact would you like to Delete?\n");
        String deleteUser = input.getString();
        int index = contactList.size() + 2;
        for (Contact contact : contactList) {
            if (contact.getName().toLowerCase().contains(deleteUser.toLowerCase())) {
                index = contactList.indexOf(contact);
                System.out.println("Index is: " + index);
            }
        }
        try {
            contactList.remove(index);
        } catch (Exception e) {
            //do nothing
        }
        System.out.println("Size is " + contactList.size());
        for (Contact temp : contactList) {
            System.out.println(temp.getName());
        }
    }
    public static void writeToFile() {
        try {
            List<String> lines = new ArrayList<>();
            for (Contact contact : contactList) {
                lines.add(contact.getName() + "," + contact.getPhoneNumber());
            }
            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("Error Writing contact to files");
        }
    }
}

