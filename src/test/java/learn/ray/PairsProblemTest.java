package learn.ray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PairsProblemTest {

    PairsProblem pairsProblem;

    @Before
    public void setUp() throws Exception {
        pairsProblem = new PairsProblem();
    }

    @Test
    public void testPairsProblem1() throws Exception {
        String expression = "(.)(.)";
        Assert.assertTrue(pairsProblem.checkExpressionCorrect(expression));
    }

    @Test
    public void testPairsProblem2() throws Exception {
        String expression = "((.)(.)adsd)";
        Assert.assertTrue(pairsProblem.checkExpressionCorrect(expression));
    }

    @Test
    public void testPairsProblemNegative() throws Exception {
        String expression = "(.)(.})";
        Assert.assertFalse(pairsProblem.checkExpressionCorrect(expression));
    }

}