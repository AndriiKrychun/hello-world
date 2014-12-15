package learn.ray;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
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
        smallList.add(4);
        smallList.add(5);
        boolean result = sublist(bigList, smallList);
        System.out.println(result);
    }

    public static boolean sublist(List list1, List list2) {
        int index = 0;
        for (int i = 0; i < list2.size(); i++) {
            for (int j = index + 1; j < list1.size(); j++) {
                if (list2.get(i).equals(list1.get(j))) {
                    index = j;
                    break;
                }
                index = list1.size();
            }
        }

        if (index > 0 && index < list1.size()) {
            return true;
        }
        return false;
    }
}
