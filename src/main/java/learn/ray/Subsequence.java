package learn.ray;

import tasks.SubSequenceAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Subsequence implements SubSequenceAlgorithm {
    public static void main(String[] args) {
        List bigList = new ArrayList();
        List smallList = new ArrayList();
        bigList.add(1);
        bigList.add(2);
        bigList.add(3);
        bigList.add(4);
        bigList.add(5);
        bigList.add(6);
        bigList.add(7);
        smallList.add(2);
        smallList.add(2);
        smallList.add(5);
        Subsequence subsequence = new Subsequence();
        boolean result = subsequence.isSubSequence(bigList, smallList);
        System.out.println(result);
    }


    @Override
    public boolean isSubSequence(List list, List list1) {
        int index = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = index + 1; j < list.size(); j++) {
                if (list1.get(i).equals(list.get(j))) {
                    index = j;
                    break;
                }
                index = list.size();
            }
        }

        if (index > 0 && index < list.size()) {
            return true;
        }
        return false;
    }
}
