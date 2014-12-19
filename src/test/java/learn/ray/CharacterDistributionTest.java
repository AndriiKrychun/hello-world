package learn.ray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import tasks.LeapYear;


@RunWith(Parameterized.class)
public class CharacterDistributionTest {


    @Parameterized.Parameter
    public CharacterDistribution characterDistribution = new CharacterDistribution();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new CharacterDistribution()});
        return params;
    }

    @Test
    public void testGetDistribution() throws Exception {
        Map<Character, Integer> expectedCharDistr = new HashMap<>();
        expectedCharDistr.put('d', 3);
        expectedCharDistr.put('a', 4);
        expectedCharDistr.put('s', 4);
        Map<Character, Integer> actualCharDistr = characterDistribution.getDistribution("asdaddsssaa");
        Assert.assertEquals(expectedCharDistr, actualCharDistr);
    }
}