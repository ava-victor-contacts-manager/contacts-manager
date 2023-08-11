package Contact;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsInfo {

    //Global
    private static final ArrayList<Contact> contactList = readFromFile();
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
        int choice;
        while (true) {
            choice = showMenu();
            if (choice == 1) {
                showAllContacts();
                System.out.print("╔════════════════════════════════╗\n \uD835\uDC6B\uD835\uDC90 \uD835\uDC9A\uD835\uDC90\uD835\uDC96 \uD835\uDC98\uD835\uDC82\uD835\uDC8F\uD835\uDC95 \uD835\uDC95\uD835\uDC90 \uD835\uDC84\uD835\uDC90\uD835\uDC8F\uD835\uDC95\uD835\uDC8A\uD835\uDC8F\uD835\uDC96\uD835\uDC86? [\uD835\uDC9A/\uD835\uDC8F]\n╚════════════════════════════════╝\n");
                String userContinue = input.getString();
                if (userContinue.equalsIgnoreCase("y")) {
                } else {
                    writeToFile();
                    break;
                }
            } else if (choice == 2) {
                addNewContact();
                System.out.print("Do you want to continue? [y/n]: ");
                String userContinue = input.getString();
                if (userContinue.equalsIgnoreCase("y")) {
                } else {
                    writeToFile();
                    break;
                }
            } else if (choice == 3) {
                searchContacts();
                System.out.print("Do you want to continue? [y/n]: ");
                String userContinue = input.getString();
                if (userContinue.equalsIgnoreCase("y")) {
                } else {
                    writeToFile();
                    break;
                }
            } else if (choice == 4) {
                deleteContact();
                System.out.print("Do you want to continue? [y/n]: ");
                String userContinue = input.getString();
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

    public static int showMenu() {
        Input input = new Input();
        System.out.println("╔═.✵.═══════════════════════════════════╗\n   1. \uD83D\uDCDE \uD835\uDCB1\uD835\uDCBEℯ\uD835\uDCCC \uD835\uDC9Eℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9\uD835\uDCC8, \uD83D\uDCDE. \n   2. \uD83D\uDC64 \uD835\uDC9C\uD835\uDCB9\uD835\uDCB9 \uD835\uDCC3ℯ\uD835\uDCCC \uD835\uDCB8ℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9\uD835\uDCC8, \uD83D\uDC64.\n   3. \uD83D\uDD0E \uD835\uDCAEℯ\uD835\uDCB6\uD835\uDCC7\uD835\uDCB8\uD835\uDCBD \uD835\uDCB8ℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9 \uD835\uDCB7\uD835\uDCCE \uD835\uDCC3\uD835\uDCB6\uD835\uDCC2ℯ, \uD83D\uDD0E. \n   4. \uD83D\uDDD1 \uD835\uDC9Fℯ\uD835\uDCC1ℯ\uD835\uDCC9ℯ \uD835\uDCB6\uD835\uDCC3 ℯ\uD835\uDCCD\uD835\uDCBE\uD835\uDCC8\uD835\uDCC9\uD835\uDCBE\uD835\uDCC3\uD835\uDC54 \uD835\uDCB8ℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9, \uD83D\uDDD1. \n   5. ℰ\uD835\uDCCD\uD835\uDCBE\uD835\uDCC9, .\n   ℰ\uD835\uDCC3\uD835\uDCC9ℯ\uD835\uDCC7 \uD835\uDCB6\uD835\uDCC3 ℴ\uD835\uDCC5\uD835\uDCC9\uD835\uDCBEℴ\uD835\uDCC3 (1, 2, 3, 4 ℴ\uD835\uDCC7 5) \n╚═══════════════════════════════════.✵.═╝");
        int usersInput = input.getInt();
        return usersInput;
    }

    public static void showAllContacts() {
        System.out.println(contactList);
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

    public static void searchContacts() {
        System.out.println("Who would you like to search for?");
        String usersSearch = input.getString();
        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.getName().toLowerCase().contains(usersSearch)) {
                System.out.println(contact);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Couldn't find anyone by that name");
        }
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

