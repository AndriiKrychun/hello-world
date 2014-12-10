package learn.ray;

import java.util.Scanner;

public class SumFromString {

    public static void main(String[] args) {
        int sum=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers split by some letters : ");
        String input = scanner.next();
        String numbers[] = input.split("\\D+");
        for (int i=0; i<numbers.length;i++)
        {
            sum += Integer.valueOf(numbers[i]);
        }
        System.out.println(Integer.toString(sum));

    }

}
