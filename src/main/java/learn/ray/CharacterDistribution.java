package learn.ray;

import tasks.CharacterDistributionAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterDistribution implements CharacterDistributionAlgorithm {

//    public static void main(String[] args) {
//        CharacterDistribution characterDistribution = new CharacterDistribution();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter string : ");
//        String input = scanner.next();
//        Map<Character, Integer> charDistr = characterDistribution.getDistribution(input);
//        for (Map.Entry<Character, Integer> entry : charDistr.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//
//    }


    @Override
    public Map<Character, Integer> getDistribution(String s) {
        Map<Character, Integer> charDistr = new HashMap<>();
        char[] chars = s.toCharArray();
        for (Character ch : chars) {
            Integer numberOfChars = charDistr.get(ch);
            int newNum = 1;
            if (!(numberOfChars == null)) {
                newNum = ++numberOfChars;
            }
            charDistr.put(ch, newNum);
        }
        return charDistr;
    }
}