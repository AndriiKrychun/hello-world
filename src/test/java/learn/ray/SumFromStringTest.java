package learn.ray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SumFromStringTest {

    SumFromString sumFromString;

    @Before
    public void setUp() throws Exception {
        sumFromString = new SumFromString();
    }

    @Test
    public void testSumFromString() throws Exception {
        double expectedSum = 8.0;
        double actualSum = sumFromString.getSumFromString("1i3lh4");
        Assert.assertEquals(expectedSum, actualSum, 0.01);
    }
}