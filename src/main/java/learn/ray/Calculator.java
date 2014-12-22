package learn.ray;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) {
        float result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression : ");
        String input = scanner.next();

        Pattern pat = Pattern.compile("((\\d+)(\\.\\d+)?)([\\+\\-\\/\\*])((\\d+)(\\.\\d+)?)");
        Matcher mat = pat.matcher(input);
        mat.find();
        String oper1 = mat.group(1);
        String operator = mat.group(4);
        String oper2 = mat.group(5);


        System.out.println(mat.group(1) + " -- " + mat.group(4) + " -- " + mat.group(5));


        switch (operator) {
            case "+":
                result = Float.valueOf(oper1) + Float.valueOf(oper2);
                break;
            case "-":
                result = Float.valueOf(oper1) - Float.valueOf(oper2);
                break;
            case "*":
                result = Float.valueOf(oper1) * Float.valueOf(oper2);
                break;
            case "/":
                result = Float.valueOf(oper1) / Float.valueOf(oper2);
                break;

        }
        System.out.println(Float.toString(result));

    }

}

