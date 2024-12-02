package Nr1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListReader {

    public ListReader (){
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader (new FileReader("src/Nr1/input.txt")))
        {
            String line;
            while ((line = br.readLine()) != null) {
                lineSplitter(firstList,secondList, line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(firstList);
        Collections.sort(secondList);

        int result = diffrenceAdder(firstList,secondList);

        System.out.println(result);
    }

    private void lineSplitter(List<Integer> firstList, List<Integer> secondList,String line) {
        String tempFirst = line.substring(0,line.indexOf(" "));
        String tempSecond = line.substring(line.lastIndexOf(" ")+1);
        firstList.add(Integer.parseInt(tempFirst));
        secondList.add(Integer.parseInt(tempSecond));
    }

    private int diffrenceAdder(List<Integer> firstList, List<Integer> secondList) {
        int result = 0;
        if(firstList.size() == secondList.size()) {
            for (int i = 0; i < firstList.size(); i++) {
                int firstInt = firstList.get(i);
                int secondInt = secondList.get(i);
                int temp;
                if (firstInt > secondInt) {
                    temp = firstInt - secondInt;
                    result += temp;
                } else {
                    temp = secondInt - firstInt;
                    result += temp;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        new ListReader();
    }
}
