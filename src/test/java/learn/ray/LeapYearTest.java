package learn.ray;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tasks.LeapYearAlgorithm;

import java.util.ArrayList;
import java.util.Collection;


@RunWith(Parameterized.class)
public class LeapYearTest {

    @Parameterized.Parameter
    public LeapYearAlgorithm algorithm = new LeapYear();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new LeapYear()});
        return params;
    }

    @Test
    public void testIsLeapYear() throws Exception {
        Assert.assertTrue(algorithm.isLeapYear(2000));
    }

    @Test
    public void testIsLeapYearNegative() throws Exception {
        Assert.assertFalse(algorithm.isLeapYear(2001));
    }
}