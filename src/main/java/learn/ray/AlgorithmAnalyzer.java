package learn.ray;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmAnalyzer {
    //public List<String> list=null;

    public static void main(String[] args) {
        //List<String> list = new MyArrayList<>();
        List<String> list = new ArrayList<>();

        try  {
            Scanner scanner = new Scanner(new FileInputStream("src\\main\\java\\learn\\ray\\inputfile"));
            while (scanner.hasNext()) {
                String str = scanner.next();
                list.add(str);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String temp = null;
        for(int j = 0 ; j < list.size(); j++){
            for(int i = 0 ; i < list.size() - j; i++){

                if(list.get(i).compareTo(list.get(i+1)) > 0){
                    temp = list.get(i);
                    list.set(i,list.get(i+1)) ;
                    list.set((i+1),temp);
                }
            }
        }

    }


    private List<String> sort(List<String> list){
        String temp = null;
        for(int j = 0 ; j < list.size(); j++){
            for(int i = 0 ; i < list.size() - j; i++){

                if(list.get(i).compareTo(list.get(i+1)) > 0){
                    temp = list.get(i);
                    list.set(i,list.get(i+1)) ;
                    list.set((i+1),temp);
                }
            }
        }
        return list;
    }

}
