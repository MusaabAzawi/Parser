import java.io.*;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        String filename = "genres";      //De file die je wilt parsen die in de map data zit
        String pattern = "^(.*?)\\s\\(([0-9 ?\\/A-Z]*)\\)\\{?([{}a-zA-Z ]*)?\\}?\\s*\\(?(TV|V)?(VG)?\\)?\\s*([a-zA-Z\\-]*)$";
        // De reguliere explressie
        PrintWriter writer;

        BufferedReader br = null;
        FileReader fr = null;

        {
            try {
                writer = new PrintWriter(new File("data/" + filename + ".csv"));    //Maak een nieuwe file aan zodat je er in kan schrijven
                StringBuilder columname = new StringBuilder();      //De stringbuilder wordt aangemaakt zodat de kollommen in een string geschreven kunnen worden
                columname.append("Titel,");                         //Hier krijgen de kolommen een naam
                columname.append("Jaar,");
                columname.append("onzin,");
                columname.append("onzin,");
                columname.append("platform,");
                columname.append("genre\n");

                writer.write(columname.toString());                 //Hier wordt de kolommen-string naar het .csv bestand gewrite

                Pattern r = Pattern.compile(pattern);               //Compile het pattern in een pattern object

                File myObj = new File("data/" + filename + ".list");        //Haal de file die je wilt parsen op uit de data folder

                fr = new FileReader("data/" + filename + ".list");
                br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {                    //Totdat er geen nieuwe regels meer zijn doe dit:

                    Matcher m = r.matcher(line);                    //Match de data string met de reguliere expressie

                    if (m.find()) {                                 //Als het een match is doe dit:
                        StringBuilder sb = new StringBuilder();     //maak een nieuwe stringbuilder aan voor de data


                        System.out.println(m.group(1));             //print eerst alle groepen uit ter controle
                        System.out.println(m.group(2));
                        System.out.println(m.group(3));
                        System.out.println(m.group(4));
                        System.out.println(m.group(5));


                        sb.append(m.group(1) + ",");
                        sb.append(m.group(2) + ",");
                        sb.append(m.group(3) + ",");
                        sb.append(m.group(4) + ",");
                        sb.append(m.group(5) + ",");
                        sb.append(m.group(6) + "\n");

                        writer.write(sb.toString());
                    } else {
                        System.out.println("geen match");
                    }

                }
            } catch (Exception x) {
                x.printStackTrace();
            } finally {
                if (fr != null) {
                    try {
                        br.close();
                    } catch (Exception ignoreMe) {
                    }
                    try {
                        fr.close();
                    } catch (Exception ignoreMe) {
                    }
                }

            }
        }
    }
}