package Contact;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
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

//    public static void idea(){
//
//        String yellow = "\u001B[33m";
//        String resetColo = "\u001B[0m";
//        String art = """
//                                                                                                                                     \s
//                                                                                    _____         _           _      __    _     _  \s
//                                                                                   |     |___ ___| |_ ___ ___| |_   |  |  |_|___| |_\s
//                                                                                   |   --| . |   |  _| .'|  _|  _|  |  |__| |_ -|  _|
//                                                                                   |_____|___|_|_|_| |__,|___|_|    |_____|_|___|_| \s
//                                                                                                                                        \s
//                    """;
//
//
//        try {
//            List<String> lineOfTexts = Files.readAllLines(
//                    Paths.get("src/Contact/contacts.txt")
//            );
//            System.out.println(yellow + art + resetColo);
//            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
//            for(String text : lineOfTexts){
//                System.out.println("                                                                         " +text);
//            }
//            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝ \n\n");
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
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

        title();

        while (true) {
            choice = showMenu();

            if (choice == 1) {
                showAllContacts();
                System.out.print("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n                                                                      \uD835\uDC6B\uD835\uDC90 \uD835\uDC9A\uD835\uDC90\uD835\uDC96 \uD835\uDC98\uD835\uDC82\uD835\uDC8F\uD835\uDC95 \uD835\uDC95\uD835\uDC90 \uD835\uDC84\uD835\uDC90\uD835\uDC8F\uD835\uDC95\uD835\uDC8A\uD835\uDC8F\uD835\uDC96\uD835\uDC86? [\uD835\uDC9A/\uD835\uDC8F]\n╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
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
    public static void title() {
        String blue = "\u001B[94m";
        String pink = "\u001B[35m";
        String resetColo = "\u001B[0m";

        String art = """
                 ________  ________  ________   _________  ________  ________ _________        _____ ______   ________  ________   ________  ________  _______   ________    \s
                |\\   ____\\|\\   __  \\|\\   ___  \\|\\___   ___\\\\   __  \\|\\   ____\\\\___   ___\\     |\\   _ \\  _   \\|\\   __  \\|\\   ___  \\|\\   __  \\|\\   ____\\|\\  ___ \\ |\\   __  \\   \s
                \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\ \\  \\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\___\\|___ \\  \\_|     \\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\  \\|\\  \\ \\  \\___|\\ \\   __/|\\ \\  \\|\\  \\  \s
                 \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\\\ \\  \\   \\ \\  \\ \\ \\   __  \\ \\  \\       \\ \\  \\       \\ \\  \\\\|__| \\  \\ \\   __  \\ \\  \\\\ \\  \\ \\   __  \\ \\  \\  __\\ \\  \\_|/_\\ \\   _  _\\ \s
                  \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\\\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\ \\  \\____   \\ \\  \\       \\ \\  \\    \\ \\  \\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\ \\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  \\\\  \\|\s
                   \\ \\_______\\ \\_______\\ \\__\\\\ \\__\\   \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\  \\ \\__\\       \\ \\__\\    \\ \\__\\ \\__\\ \\__\\ \\__\\\\ \\__\\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\__\\\\ _\\\s
                    \\|_______|\\|_______|\\|__| \\|__|    \\|__|  \\|__|\\|__|\\|_______|   \\|__|        \\|__|     \\|__|\\|__|\\|__|\\|__| \\|__|\\|__|\\|__|\\|_______|\\|_______|\\|__|\\|__|
                                                                                                                                                                             \s
                                                                                                                                                                             \s
                """;
        String art1 = """
                                                                 ___         _       _             _             _  _  __   ___   \s
                                                                / __|___  __| |___  | |__ _  _    /_\\__ ____ _  | \\| | \\ \\ / (_)__\s
                                                               | (__/ _ \\/ _` / -_) | '_ \\ || |  / _ \\ V / _` | | .` |  \\ V /| / _|
                                                                \\___\\___/\\__,_\\___| |_.__/\\_, | /_/ \\_\\_/\\__,_| |_|\\_|   \\_/ |_\\__|
                                                                                            |__/                                    \s
                """;

        System.out.println(blue + art + resetColo);
        System.out.println(pink+ art1 + resetColo);

    }
    public static int showMenu() {
        Input input = new Input();
        System.out.println("╔═.✵.═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "                                                                             1. \uD835\uDCB1\uD835\uDCBEℯ\uD835\uDCCC \uD835\uDCB8ℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9\uD835\uDCC8. \n\n                                                                          2.  \uD835\uDC9C\uD835\uDCB9\uD835\uDCB9 \uD835\uDCB6 \uD835\uDCC3ℯ\uD835\uDCCC \uD835\uDCB8ℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9. \n\n                                                                     3. \uD83D\uDD0E \uD835\uDCAEℯ\uD835\uDCB6\uD835\uDCC7\uD835\uDCB8\uD835\uDCBD \uD835\uDCB8ℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9 \uD835\uDCB7\uD835\uDCCE \uD835\uDCC3\uD835\uDCB6\uD835\uDCC2ℯ, \uD83D\uDD0E. \n\n                                                                    4. \uD83D\uDDD1 \uD835\uDC9Fℯ\uD835\uDCC1ℯ\uD835\uDCC9ℯ \uD835\uDCB6\uD835\uDCC3 ℯ\uD835\uDCCD\uD835\uDCBE\uD835\uDCC8\uD835\uDCC9\uD835\uDCBE\uD835\uDCC3\uD835\uDC54 \uD835\uDCB8ℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9, \uD83D\uDDD1. \n\n                                                                                5. ℰ\uD835\uDCCD\uD835\uDCBE\uD835\uDCC9, .\n\n                                                                     ℰ\uD835\uDCC3\uD835\uDCC9ℯ\uD835\uDCC7 \uD835\uDCB6\uD835\uDCC3 ℴ\uD835\uDCC5\uD835\uDCC9\uD835\uDCBEℴ\uD835\uDCC3 (1, 2, 3, 4 ℴ\uD835\uDCC7 5) \n╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════.✵.═╝ \n\n");
        int usersInput = input.getInt();
        return usersInput;
    }
    public static void showAllContacts() {
        System.out.println(contactList);
    }
    public static void addNewContact() {
        String yellow = "\u001B[33m";
        String resetColo = "\u001B[0m";


        String art = """
                                                                                                                                        \s
                                                                         _____   _   _ _                   _____         _           _  \s
                                                                        |  _  |_| |_| |_|___ ___    ___   |     |___ ___| |_ ___ ___| |_\s
                                                                        |     | . | . | |   | . |  | .'|  |   --| . |   |  _| .'|  _|  _|
                                                                        |__|__|___|___|_|_|_|_  |  |__,|  |_____|___|_|_|_| |__,|___|_| \s
                                                                                            |___|                                       \s
                """;

        System.out.println(yellow + art + resetColo );
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("\n                                                                           ℰ\uD835\uDCC3\uD835\uDCC9ℯ\uD835\uDCC7 \uD835\uDCBB\uD835\uDCBE\uD835\uDCC7\uD835\uDCC8\uD835\uDCC9 \uD835\uDCB6\uD835\uDCC3\uD835\uDCB9 \uD835\uDCC1\uD835\uDCB6\uD835\uDCC8\uD835\uDCC9 \uD835\uDCC3\uD835\uDCB6\uD835\uDCC2ℯ: \n");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        String usersName = input.getString();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("\n                                                                            ℰ\uD835\uDCC3\uD835\uDCC9ℯ\uD835\uDCC7 \uD835\uDCAB\uD835\uDCBDℴ\uD835\uDCC3ℯ\uD835\uDCC3\uD835\uDCCA\uD835\uDCC2\uD835\uDCB7ℯ\uD835\uDCC7: \n");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        String usersPhoneNumber = input.getString();
        String formattedPhoneNumber = usersPhoneNumber.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        Contact tempContact = new Contact();
        Contact newContact = new Contact(usersName, formattedPhoneNumber);

        for (Contact contact : contactList) {
            if (!newContact.equals(contact)) {
                tempContact = newContact;
            }
        }
//        contactList.add(idea);
        contactList.add(tempContact);
        System.out.println("""
                                                                                                                                   __\s
                                                                              _____         _           _            _   _       _|  |
                                                                             |     |___ ___| |_ ___ ___| |_    ___ _| |_| |___ _| |  |
                                                                             |   --| . |   |  _| .'|  _|  _|  | .'| . | . | -_| . |__|
                                                                             |_____|___|_|_|_| |__,|___|_|    |__,|___|___|___|___|__|
                                                                                                                                     \s
                """);
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
//                System.out.println("Index is: " + index);
            }
        }
        try {
            contactList.remove(index);
        } catch (Exception e) {
            //do nothing
        }
        System.out.println("╔═.✵.═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗ \n                                                           Deleted, your contact list is: \n ╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════.✵.═╝");
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

