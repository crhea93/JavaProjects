import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class readCredentials {
    static public ArrayList<String> readCredentials(String file_path)throws Exception {
        // pass the path to the file as a parameter
        Scanner s = new Scanner(new File(file_path));
        ArrayList<String> credentials = new ArrayList<>();
        while (s.hasNext()) {
            String line;
            line = s.next();
            credentials.add(line);
        }
        s.close();
        return credentials;

}


}
