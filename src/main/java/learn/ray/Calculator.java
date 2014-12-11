package learn.ray;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) {
        int sum=0;
        float result=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression : ");
        String input = scanner.next();

        Pattern pat = Pattern.compile("(\\d+)([\\+\\-\\/\\*])(\\d+)");
        Matcher mat = pat.matcher(input);
        mat.find();
        String oper1 = mat.group(1);
        String operator = mat.group(2);
        String oper2 = mat.group(3);

        //Scanner sc = new Scanner(input);
        //sc.useDelimiter("[+-]");
        //String oper1 = sc.next();
        //String oper2 = sc.next();

        switch (operator)
        {
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

