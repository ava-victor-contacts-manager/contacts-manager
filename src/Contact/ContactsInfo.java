package Contact;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ContactsInfo {
    public static void main(String[] args) {

//                    System.out.println("1. View contacts.\n2. Add a new contact. \n3. Search a contact by name. \n4. Delete an existing contact. \n5. Exit.\nEnter an option (1, 2, 3, 4 or 5):");

//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("1. View contacts.\n2. Add a new contact. \n3. Search a contact by name. \n4. Delete an existing contact. \n5. Exit.\nEnter an option (1, 2, 3, 4 or 5):");
//            for ( ){
//                System.out.print();
//            }
//        }
//    }


        Contacts bill = new Contacts("Billy Bob", 2103456784);
        Contacts sandy = new Contacts("Sandy Cheeks", 2103456784);
        Contacts tom = new Contacts("Tommy Tom", 2103456784);

        ArrayList<Contacts> contactList = new ArrayList<>();
        contactList.add(bill);
        contactList.add(sandy);
        contactList.add(tom);

//        System.out.println(contactList);
        System.out.println(bill.getName());
        System.out.println(bill.getPhoneNumber());
    }
}
