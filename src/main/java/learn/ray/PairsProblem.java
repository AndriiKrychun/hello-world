package learn.ray;

import tasks.PairedBracketsAlgorithm;

import java.util.Scanner;

public class PairsProblem implements PairedBracketsAlgorithm {

    public static void main(String[] args) {
        PairsProblem pp = new PairsProblem();
        System.out.print("Enter expression");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(pp.checkExpressionCorrect(expression) ? "YES" : "NO");
    }

    @Override
    public boolean checkExpressionCorrect(String s) {
        s = s.replaceAll("[^\\(|^\\)|^\\[|^\\]|^\\{|^\\}]", "");
        s = s.replaceAll("(\\(\\)|\\[\\]|\\{\\})", "");
        if (0 == s.length()) {
            return true;
        }
        return false;
    }
}