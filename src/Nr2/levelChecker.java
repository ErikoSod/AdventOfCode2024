package Nr2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class levelChecker {

    levelChecker(){
        try(BufferedReader br = new BufferedReader (new FileReader("src/Nr2/input.txt")))
        {
            int numberOfSafeReports = 0;
            String line;
            while ((line = br.readLine()) != null) {

                numberOfSafeReports += safeChecker(line);
            }

            System.out.println(numberOfSafeReports);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int safeChecker(String line) {
        int direction = directionChecker(line);
        int safeChecker = 0;
        boolean increase;
        switch (direction) {
            case 1 -> increase = true;
            case -1 -> increase = false;
            default -> {
                return 0;
            }
        }
        while (line.length() > 2) {
            String tempFirstNumber = line.substring(0, line.indexOf(" "));
            line = line.replaceFirst(tempFirstNumber, "").trim();
            String tempSecondNumber;
            if(line.length() > 2){
                tempSecondNumber = line.substring(0, line.indexOf(" "));
            }else {
                tempSecondNumber = line;
            }
            int tempIntFirstNumber = Integer.parseInt(tempFirstNumber);
            int tempIntSecondNumber = Integer.parseInt(tempSecondNumber);
            int safe;
            if (increase) {
                safe = tempIntSecondNumber - tempIntFirstNumber;
            } else {
                safe = tempIntFirstNumber - tempIntSecondNumber;
            }
            switch (safe) {
                case 1, 3, 2 -> safeChecker = 1;
                default -> {
                    return 0;
                }
            }
        }
        return safeChecker;
    }

    private int directionChecker(String line) {

        int direction =0;
        String tempFirstNumber = line.substring(0, line.indexOf(" "));
        line = line.replaceFirst(tempFirstNumber, "").trim();
        String tempSecondNumber ="";
        tempSecondNumber = line.substring(0, line.indexOf(" "));
        int tempIntFirstNumber = Integer.parseInt(tempFirstNumber);
        int tempIntSecondNumber = Integer.parseInt(tempSecondNumber);
        if (tempIntFirstNumber > tempIntSecondNumber) {
            direction = -1;
        } else if (tempIntFirstNumber < tempIntSecondNumber) {
            direction = 1;
        }
        return direction;
    }

    public static void main(String[] args) {
        new levelChecker();
    }
}
