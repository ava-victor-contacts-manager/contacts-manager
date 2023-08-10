package Contact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.util.*;

public class ContactsInfo {

    public static void main(String[] args) {

        Path p = Paths.get("src/Contact/contacts.text");

        Contacts bill = new Contacts("Billy Bob", "2103456784");
        Contacts sandy = new Contacts("Sandy Cheeks", "2103456784");
        Contacts tom = new Contacts("Tommy Tom", "2103456784");



        ArrayList<Contacts> contactList = new ArrayList<>();
        contactList.add(bill);
        contactList.add(sandy);
        contactList.add(tom);

//        System.out.println(Contacts);


        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. View contacts.\n2. Add a new contact. \n3. Search a contact by name. \n4. Delete an existing contact. \n5. Exit.\nEnter an option (1, 2, 3, 4 or 5):");
            Integer usersInput = Integer.valueOf(sc.next());
            if (usersInput == 1) {
                for (Contacts contact : contactList) {
                    System.out.println(contact);
                }
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

//    public static void showAllContacts() {
//        System.out.println(Contacts);
//    }

    //methods

    public static void addNewContact() {

    }

    public static void searchContacts(){

    }

    public static void deleteContact() {

    }

}
