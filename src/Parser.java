import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.PrintWriter;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;

public class Parser {
    public static void main(String[] args) {
        String filename = "data/testcountries.list";      //De file die je wilt parsen die in de map data zit

        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (Exception x) {
            x.printStackTrace();
        }
        finally {
            if (fr != null) {
                try {br.close();} catch (Exception ignoreMe) {}
                try {fr.close();} catch (Exception ignoreMe) {}
            }

    }
}
}