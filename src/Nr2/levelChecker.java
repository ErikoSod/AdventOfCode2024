package Nr2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
                numberOfSafeReports+= decreaseAndIncrease(lineAsList);

            }
            System.out.println(numberOfSafeReports);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int decreaseAndIncrease(List<Integer> lineAsList){
        int result = 0;
        if((1==safeChecker(lineAsList,1))||(1==safeChecker(lineAsList,-1))){
            result = 1;
        }
        return result;
    }

    public int safeChecker(List<Integer> lineAsList,int decrease) {

        for (int i = 0; i <lineAsList.size(); i++) {
            int Warnings = 0;
            List<Integer> oneElementRemovedList = new ArrayList<>(lineAsList);
            oneElementRemovedList.remove(i);

             for (int j = 0; j < oneElementRemovedList.size() - 1; j++) {
                 int tempDifference = oneElementRemovedList.get(j + 1) - oneElementRemovedList.get(j);
                 switch (tempDifference * decrease) {
                    case 1, 2, 3 -> Warnings += 0;
                    default -> Warnings ++;
                 }
             }
            if (Warnings == 0) {
                return 1;
            }
        }
        return 0;
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
