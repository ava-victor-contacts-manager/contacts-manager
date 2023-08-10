package Contact;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static void main(String[] args) {

        Path filePath = Paths.get("src/contact/ContactsInfo.java");
        System.out.println(Files.exists(filePath));

        String packageName = "Contact";
        String fileName = "contacts.txt";

        //This allows us to get the package inside the Directory
        Path dataDirectory = Paths.get("src", packageName);
        Path dataFile = dataDirectory.resolve(fileName);
        System.out.println(dataFile);

//        if (!Files.exists(dataFile)) {
//            try {
//                Files.createDirectories(dataDirectory); // Create the subdirectory if it doesn't exist
//                Files.createFile(dataFile);
//                System.out.println("File created successfully.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("File already exists.");
//        }

        //         Path p = Paths.get("data/info.txt");
//        List<String> lineOfText = new ArrayList<>();
//        try {
//            lineOfText = Files.readAllLines(p);
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//
//        System.out.println(lineOfText); =======================

        //PRINTS ALL IN A SINGLE LINE
        Path p = Paths.get("src/Contact/contacts.txt");
        List<String> lineOfText = new ArrayList<>();
        try {
            lineOfText = Files.readAllLines(p);
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(lineOfText);

//        try {
//            List<String> lineOfTexts = Files.readAllLines(
//                    Paths.get("src/Contact/contacts.txt")
//            );
//
//            for(String text : lineOfTexts){
//                System.out.println(text);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }

    }

}
