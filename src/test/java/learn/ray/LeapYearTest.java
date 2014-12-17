package learn.ray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LeapYearTest {

    LeapYear algorithm;

    @Before
    public void setUp() throws Exception {
        algorithm = new LeapYear();
    }

    @Test
    public void testIsLeapYear() throws Exception {
        Assert.assertTrue(algorithm.isLeapYear(2000));
    }
}