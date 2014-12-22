package learn.ray;

import tasks.PairedBracketsAlgorithm;

public class PairsProblem implements PairedBracketsAlgorithm {

//    public static void main(String[] args) {
//        PairsProblem pp = new PairsProblem();
//        System.out.print("Enter expression");
//        Scanner scanner = new Scanner(System.in);
//        String expression = scanner.nextLine();
//        System.out.println(pp.checkExpressionCorrect(expression) ? "YES" : "NO");
//    }

    @Override
    public boolean checkExpressionCorrect(String expression) {
        expression = expression.replaceAll("[^\\(|^\\)|^\\[|^\\]|^\\{|^\\}]", "");
        String tempExpression;
        do {
            tempExpression = expression;
            expression = expression.replaceAll("(\\(\\)|\\[\\]|\\{\\})", "");
        } while (!expression.equals(tempExpression));

        if (0 == expression.length()) {
            return true;
        }
        return false;
    }
}