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

//        Path p = Paths.get("src/Contact/contacts.text");

        Contacts bill = new Contacts("Billy Bob", 2103456784);
        Contacts sandy = new Contacts("Sandy Cheeks", 2103456784);
        Contacts tom = new Contacts("Tommy Tom", 2103456784);

        HashMap<String, Integer> Contacts = new HashMap<>();
        Contacts.put("Billy Bob", 2103456784 );
        Contacts.put("Sandy Cheeks", 2103456784 );
        Contacts.put("Tommy Tom", 2103456784 );


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
                System.out.println(Contacts);
            }
            break;
        }
    }

    //methods


}
