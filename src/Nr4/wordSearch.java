package Nr4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TODO Hitta: Hor:5 Ver:3 Dia:4 ,Ska vara: Hor:5 Ver:3 Dia:4
public class wordSearch {
    public int foundXmas =0;
    public String input =
                        //List colum
        "MMMSXXMASM\n" +//0
        "MSAMXMSMSA\n" +//1
        "AMXSXMAAMM\n" +//2
        "MSAMASMSMX\n" +//3
        "XMASAMXAMM\n" +//4
        "XXAMMXXAMA\n" +//5
        "SMSMSASXSS\n" +//6
        "SAXAMASAAA\n" +//7
        "MAMMMXMMMM\n" +//8
        "MXMXAXMASX";   //9

    public List<List<Character>> colum = new ArrayList<>();

    public wordSearch() {
        creatList();
        /*
        for(List<Character> row : colum) {
            System.out.println(row.toString());
        }

         */
        foundXmas = listSearch(colum);
        System.out.println(foundXmas);
    }
    private int listSearch(List<List<Character>> colum) {
        int foundXmas =0;

        for (int y = 0; y < colum.size(); y++) {
            List<Character> row = colum.get(y);

            for (int x = 0; x < row.size(); x++) {
                Character c = row.get(x);

                if(c.equals('X')) {
                    foundXmas += horizontal(row,x);
                    foundXmas += vertical(colum, y, x);
                    foundXmas += diagonal(colum, y, x);
                }
            }
        }
        return foundXmas;
    }

    private int horizontal(List<Character> row, int startX) {
        int foundXmas =0;
        StringBuilder word = new StringBuilder();

        for (int x = startX; x < row.size(); x++) {
            Character c = row.get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString(),x+1,0);
                break;
            }
        }
        //foundXmas += checkForXmas(word.toString());
        word = new StringBuilder();

        for (int x = startX; x >= 0; x--) {
            Character c = row.get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString(),x+1,0);
                break;
            }
        }
        //foundXmas += checkForXmas(word.toString());
        return foundXmas;
    }



    private int vertical(List<List<Character>>colum, int startY, int x ) {
        int foundXmas =0;
        StringBuilder word = new StringBuilder();

        for (int y = startY; y < colum.size(); y++) {//Kollar ner
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {

                foundXmas += checkForXmas(word.toString(),x+1,startY+1);
                break;
            }
        }
        //foundXmas += checkForXmas(word.toString());//kollar upp
        word = new StringBuilder();
        for (int y = startY; y >= 0; y--) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {

                foundXmas += checkForXmas(word.toString(),x+1,startY+1);
                break;
            }
        }
        //foundXmas += checkForXmas(word.toString());

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
                foundXmas += checkForXmas(word.toString(),x+1,y+1);
                break;
            }
            if(colum.get(y).size()-1==x)
            {
                break;
            }
            ++x;
        }
        //foundXmas += checkForXmas(word.toString());
        x = startX;
        word = new StringBuilder();

        for (int y = startY; y >= 0; y--) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString(),x+1,y+1);
                break;
            }
            if(colum.get(y).size()-1==x)
            {
                break;
            }
            ++x;
        }
        //foundXmas += checkForXmas(word.toString());
        word = new StringBuilder();
        x = startX;

        for (int y = startY; y < colum.size(); y++) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString(),x+1,y+1);
                break;
            }
            if(0==x)
            {
                break;
            }
            --x;
        }
        //foundXmas += checkForXmas(word.toString());
        word = new StringBuilder();
        x = startX;
        for (int y = startY; y >= 0; y--) {
            Character c = colum.get(y).get(x);
            word.append(c);
            if(c.equals('S')) {
                foundXmas += checkForXmas(word.toString(),x+1,y+1);
                break;
            }
            if(0==x)
            {
                break;
            }
            --x;
        }
        //foundXmas += checkForXmas(word.toString());
        return foundXmas;
    }

    public void creatList(){
        Scanner sc = new Scanner(input);
        while(sc.hasNext()) {

            List<Character> row = new ArrayList<>();
            String line = sc.nextLine();
            for(int i = 0; i < line.length(); i++){
                row.add(line.charAt(i));
            }
            colum.add(row);
        }
    }

    private int checkForXmas(String word,int x, int y) {

        if(word.equals("XMAS")){
            //System.out.println("Rätt vid :"+x+","+y);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        new wordSearch();
    }
}
