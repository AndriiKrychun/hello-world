package learn.ray;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean guess = false;
        int num = (int) (Math.random() * 1000);
        System.out.println("Try to guess the number between 0 and 1000 :");
        Scanner scanner = new Scanner(System.in);
        while (!guess) {
            int input = scanner.nextInt();
            if (input == num) {
                System.out.println("Win!");
                guess = true;
            } else if (input < num) {
                System.out.println("Your number is smaller. Try again :");
            } else if (input > num) {
                System.out.println("Your number is greater. Try again :");
            }
        }
    }
}
