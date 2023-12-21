package Contact;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static void main(String[] args) {


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

}
