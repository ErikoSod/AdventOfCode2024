package Nr4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSearch {
    public int foundXMAS;
    public int foundMASinAnX;
    boolean XMAS = false;
    boolean MASAsX = true;


    public List<List<Character>> colum;


    public WordSearch() {

        try(BufferedReader br = new BufferedReader (new FileReader("src/Nr4/input.txt")))
        {

            String line;
            StringBuilder inputLine = new StringBuilder();
            while ((line = br.readLine()) != null) {
                inputLine.append(line).append("\n");
            }
            creatInputList(inputLine.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        foundXMAS = listSearch(colum,XMAS);
        foundMASinAnX = listSearch(colum, MASAsX);

        System.out.println("Number of XMAS found: "+foundXMAS);
        System.out.println("Number of MAS in a X found: "+foundMASinAnX);
    }
    private int listSearch(List<List<Character>> colum, boolean masAsX) {

        int foundXmas =0;
        int indexConstraints =0;

        if(masAsX){
            indexConstraints = 1;
        }
        for (int y = indexConstraints; y < colum.size()- indexConstraints; y++) {
            List<Character> row = colum.get(y);

            for (int x = indexConstraints; x < row.size()- indexConstraints; x++) {
                Character c = row.get(x);

                if(c.equals('X') && 0== indexConstraints) {
                    foundXmas += horizontal(row,x);
                    foundXmas += vertical(colum, y, x);
                    foundXmas += diagonal(colum, y, x);
                }
                if(c.equals('A')&& 1== indexConstraints) {

                        foundXmas += xSearch(colum, y, x);
                }
            }
        }
        return foundXmas;
    }

    private int xSearch(List<List<Character>>colum, int startY, int startX ) {

        int foundMasAsX =0;
        StringBuilder word = new StringBuilder();
        Character c = colum.get(startY).get(startX);
            word.append(c);
            c = colum.get(startY -1).get(startX -1);//Up Left
            word.append(c);
            c = colum.get(startY -1).get(startX +1);//Up Right
            word.append(c);
            c = colum.get(startY +1).get(startX -1);//Down Left
            word.append(c);
            c = colum.get(startY +1).get(startX +1);//Down Right
            word.append(c);

        foundMasAsX += checkForMasAsX(word.toString());
        return foundMasAsX;
    }

    private int horizontal(List<Character> row, int startX) {
        int foundXmas =0;
        StringBuilder word = new StringBuilder();

        for (int x = startX; x < row.size(); x++) {
            Character c = row.get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString());
                break;
            }
        }
        word = new StringBuilder();

        for (int x = startX; x >= 0; x--) {
            Character c = row.get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString());
                break;
            }
        }
        return foundXmas;
    }



    private int vertical(List<List<Character>>colum, int startY, int x ) {
        int foundXmas =0;
        StringBuilder word = new StringBuilder();

        for (int y = startY; y < colum.size(); y++) {//Kollar ner
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {

                foundXmas += checkForXmas(word.toString());
                break;
            }
        }

        word = new StringBuilder();
        for (int y = startY; y >= 0; y--) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {

                foundXmas += checkForXmas(word.toString());
                break;
            }
        }

        return foundXmas;
    }

    private int diagonal(List<List<Character>>colum, int startY, int startX ) {

        int foundXmas =0;
        int x = startX;
        StringBuilder word = new StringBuilder();

        for (int y = startY; y < colum.size(); y++) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString());
                break;
            }
            if(colum.get(y).size()-1==x)
            {
                break;
            }
            ++x;
        }

        x = startX;
        word = new StringBuilder();

        for (int y = startY; y >= 0; y--) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString());
                break;
            }
            if(colum.get(y).size()-1==x)
            {
                break;
            }
            ++x;
        }

        word = new StringBuilder();
        x = startX;

        for (int y = startY; y < colum.size(); y++) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString());
                break;
            }
            if(0==x)
            {
                break;
            }
            --x;
        }

        word = new StringBuilder();
        x = startX;
        for (int y = startY; y >= 0; y--) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString());
                break;
            }
            if(0==x)
            {
                break;
            }
            --x;
        }

        return foundXmas;
    }

    private int checkForMasAsX(String word) {

            if(word.equals("AMMSS")||word.equals("ASSMM")||word.equals("AMSMS")||word.equals("ASMSM")){
                return 1;
            }
            return 0;
    }

    private int checkForXmas(String word) {

        if(word.equals("XMAS")){
            return 1;
        }
        return 0;
    }

    public void creatInputList(String input) {
        colum = new ArrayList<>();
        Scanner sc = new Scanner(input);
        while(sc.hasNext()) {

            List<Character> row = new ArrayList<>();
            String line = sc.nextLine();
            for(int i = 0; i < line.length(); i++){
                row.add(line.charAt(i));
            }
            this.colum.add(row);
        }
    }

    public static void main(String[] args) {
        new WordSearch();
    }
}
