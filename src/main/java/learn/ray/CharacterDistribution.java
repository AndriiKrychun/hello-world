package learn.ray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterDistribution {
    public static void main(String[] args) {
        Map<Character, Integer> charDistr = new HashMap<Character, Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string : ");
        String input = scanner.next();
        char[] chars = input.toCharArray();
        for (Character ch : chars) {
            Integer numberOfChars = charDistr.get(ch);
            int newNum = 1;
            if (!(numberOfChars == null)) {
                newNum = ++numberOfChars;
            }
            charDistr.put(ch, newNum);
        }

        for (Map.Entry<Character, Integer> entry : charDistr.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }


}