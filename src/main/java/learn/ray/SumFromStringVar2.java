package learn.ray;

import java.util.Scanner;

public class SumFromStringVar2 {

    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers split by \';\' : ");
        String input = scanner.next();
        String numbers[] = input.split("\\;");
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.valueOf(numbers[i]);
        }
        System.out.println(Integer.toString(sum));

    }

}
