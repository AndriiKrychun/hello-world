package learn.ray;

import tasks.CharacterDistributionAlgorithm;
import java.util.HashMap;
import java.util.Map;

public class CharacterDistribution implements CharacterDistributionAlgorithm {

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