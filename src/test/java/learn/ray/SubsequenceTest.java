package learn.ray;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tasks.SubSequenceAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//import tasks.LeapYear;

@RunWith(Parameterized.class)
public class SubsequenceTest {

    @Parameterized.Parameter
    public SubSequenceAlgorithm subsequence = new Subsequence();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new Subsequence()});
        return params;
    }


    @Test
    public void testSubsequence() throws Exception {
        List bigList = Arrays.asList("1", "2", "3", "4", "5", "6", "3");
        List smallList = Arrays.asList("2", "4", "3");
        Assert.assertTrue(subsequence.isSubSequence(bigList, smallList));
    }

    @Test
    public void testSubsequenceNegative() throws Exception {
        List bigList = Arrays.asList("1", "2", "3", "4", "5", "6", "3");
        List smallList = Arrays.asList("2", "2", "3");
        Assert.assertFalse(subsequence.isSubSequence(bigList, smallList));
    }
}