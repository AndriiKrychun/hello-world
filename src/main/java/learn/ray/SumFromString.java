package learn.ray;

import tasks.StringSumAlgorithm;

import java.util.Scanner;

public class SumFromString implements StringSumAlgorithm {

    public static void main(String[] args) {
        SumFromString sumFromString = new SumFromString();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers split by some letters : ");
        String input = scanner.next();
        double sum = sumFromString.getSumFromString(input);
        System.out.println(sum);
    }

    @Override
    public double getSumFromString(String input) {
        double sum = 0;
        String numbers[] = input.split("\\D+");
        for (String i : numbers) {
            sum += Integer.valueOf(i);
        }
        return sum;
    }
}
