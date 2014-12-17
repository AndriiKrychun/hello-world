package learn.ray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

//import tasks.LeapYear;


public class SubsequenceTest {

    Subsequence subsequence;

    @Before
    public void setUp() throws Exception {
        subsequence = new Subsequence();
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