package Nr3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Multiplier {

    public Multiplier() {

        try(BufferedReader br = new BufferedReader (new FileReader("src/Nr3/input.txt")))
        {

            String line;
            StringBuilder cleanedLine = new StringBuilder();
            while ((line = br.readLine()) != null) {
                 cleanedLine.append(cleanInputOfPunct(line));
                //System.out.println(cleanedLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public String cleanInputOfPunct(String input) {

        //input = input.replaceAll("\\p{Punct}", " ");
        //Pattern allowed = Pattern.compile("^mul\\((.*?)\\)$");
        input = input.replaceAll("[^0-9,]", " ");
        //input = input.replaceAll("[^()]*\\(([^)]*)\\)[^()]*", "($1)");
        //input = input.replaceAll("\\(","");
        //input = input.replaceAll("\\)"," ");
        String trashText = "Start";
        String numbers ="";
/*
        while (!trashText.isEmpty()) {
            trashText = input.substring(input.indexOf("mul(",")");
            input = input.replaceFirst(trashText,"");
            numbers +=" "+ input.substring(input.indexOf(0, input.indexOf(" ")));
        }

 */





        System.out.println(input);
        return input;
    }

    public static void main(String[] args) {
        new Multiplier();
    }
}
