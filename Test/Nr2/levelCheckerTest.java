package Nr2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class levelCheckerTest {

    levelChecker levelChecker = new levelChecker();

    List<Integer> list1 = new LinkedList<>(Arrays.asList(1,4,7,10,13));
    List<Integer> list2 = new LinkedList<>(Arrays.asList(20,17,14,11,8));
    List<Integer> list3 = new LinkedList<>(Arrays.asList(1,7,8,9,10));
    List<Integer> list4 = new LinkedList<>(Arrays.asList(90,22,23,24,25));
    List<Integer> list5 = new LinkedList<>(Arrays.asList(20,17,14,11,1));
    List<Integer> list6 = new LinkedList<>(Arrays.asList(20,21,23,25,90));
    List<Integer> list7 = new LinkedList<>(Arrays.asList(20,19,18,17,21));
    List<Integer> list8 = new LinkedList<>(Arrays.asList(21,22,23,24,1));
    List<Integer> list9 = new LinkedList<>(Arrays.asList(11,17,13,20,15));
    List<Integer> list10 = new LinkedList<>(Arrays.asList(1,16,13,11,9));
    List<Integer> list11 = new LinkedList<>(Arrays.asList(90,16,13,11,9));
    List<Integer> list12 = new LinkedList<>(Arrays.asList(1,2,80,3,4));
    List<Integer> list13 = new LinkedList<>(Arrays.asList(1,80,2,3,4));
    List<Integer> list14 = new LinkedList<>(Arrays.asList(1,2,3,80,4));
    List<Integer> list15 = new LinkedList<>(Arrays.asList(90,2,3,4,90));
    List<Integer> list16 = new LinkedList<>(Arrays.asList(90,89,1,87,86));
    List<Integer> list17 = new LinkedList<>(Arrays.asList(1,1,1,1,1));


    @Test
    public final void WrongList() {
        assertEquals (0,levelChecker.decreaseAndIncrease(list17));
    }
    @Test
    public final void firstAndLastWrong() {
        assertEquals (0,levelChecker.decreaseAndIncrease(list15));
    }
    @Test
    public final void lowMidNumber() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list16));
    }
    @Test
    public final void hightMidNumber() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list12));
    }
    @Test
    public final void hightMidOneNumber() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list13));
    }
    @Test
    public final void hightMidTwoNumber() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list14));
    }

    @Test
    public final void consecutiveIncreasingList() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list1));
    }

    @Test
    public final void consecutiveDecreasingList() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list2));
    }

    @Test
    public final void firstIndexLowIncreasingList() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list3));
    }
    @Test
    public final void firstIndexLowDecreasingList() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list10));
    }
    @Test
    public final void firstIndexHighIncreasingList() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list4));
    }@Test
    public final void firstIndexHighDecreasingList() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list11));
    }
    @Test
    public final void LastIndexLowDecreasingList() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list5));
    }
    @Test
    public final void LastIndexHighIncreasingList() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list6));
    }
    @Test
    public final void DecreasingListWithLastIndexHigh() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list7));
    }
    @Test
    public final void IncreasingListWithLastIndexLow() {
        assertEquals (1,levelChecker.decreaseAndIncrease(list8));
    }
    @Test
    public final void twoWrongNumbers() {
        assertEquals (0,levelChecker.decreaseAndIncrease(list9));
    }

}