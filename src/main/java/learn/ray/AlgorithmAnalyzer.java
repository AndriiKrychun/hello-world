package learn.ray;

import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

public class AlgorithmAnalyzer {


    public static void main(String[] args) {

//        List<String> list1 = new MyArrayList<>();
        MyArrayList<String> list1 = new MyArrayList<>();
        MyArrayList<String> list2 = new MyArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream("src\\main\\java\\learn\\ray\\inputfile"));
            while (scanner.hasNext()) {
                String str = scanner.next();
                list1.add(str);
                list2.add(str);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("List length: " + list1.size());
        bubbleSortAnalyze(list1);
        System.out.println("Bubble Sort: " + list1.getGetCount() + " readings, " + list1.getSetCount() + " writings.");
        insertSortAnalyze(list2);
        System.out.println("Insertion Sort: " + list2.getGetCount() + " readings, " + list2.getSetCount() + " writings.");

//        for (String str : list1) {
//            System.out.println(str);
//        }
    }


    public static void bubbleSortAnalyze(List<String> list) {
        String temp;
        for (int j = 0; j < list.size() - 1; j++) {
            for (int i = 0; i < list.size() - j - 1; i++) {

                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set((i + 1), temp);
                }
            }
        }
    }

    public static void insertSortAnalyze(List<String> list)
    {
        int i, j;
        String value;

        for(i = 1; i < list.size(); i++)
        {
            value = list.get(i);
            for (j = i - 1; j >= 0 && (list.get(j).compareTo(value)>0); j--)
            {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, value);
        }
    }

}
