package Nr2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class levelChecker {

    levelChecker(){
        try(BufferedReader br = new BufferedReader (new FileReader("src/Nr2/input.txt")))
        {
            int numberOfSafeReports = 0;
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> lineAsList;
                lineAsList = lineToList(line);
                numberOfSafeReports += safeChecker(lineAsList);
            }

            System.out.println(numberOfSafeReports);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int safeChecker(List<Integer> lineAsList) {
        int isSafe = 0;
        if (lineAsList.getFirst() >lineAsList.getLast()) {
            Collections.reverse(lineAsList);
        }
        int temp;
        for (int i = 0; i < lineAsList.size()-1; i++) {
            temp = lineAsList.get(i+1) - lineAsList.get(i);
            switch (temp){
                case 1,2,3 -> isSafe=1;
                default -> {return 0;}
            }
        }



        return isSafe;
    }

    private List<Integer> lineToList(String line) {

        List<Integer> lineAsList = new ArrayList<>();
        String tempFirstNumber;
        while (!line.isEmpty()) {
            if(line.contains(" ")){
                tempFirstNumber = line.substring(0, line.indexOf(" "));
            }else{
                tempFirstNumber = line;
            }
            line = line.replaceFirst(tempFirstNumber, "").trim();
            lineAsList.add(Integer.parseInt(tempFirstNumber));
        }
        return lineAsList;
    }

    public static void main(String[] args) {
        new levelChecker();
    }
}
