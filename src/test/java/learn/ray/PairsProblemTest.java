package learn.ray;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tasks.PairedBracketsAlgorithm;

import java.util.ArrayList;
import java.util.Collection;


@RunWith(Parameterized.class)
public class PairsProblemTest {

    @Parameterized.Parameter
    public PairedBracketsAlgorithm pairsProblem = new PairsProblem();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new PairsProblem()});
        return params;
    }

//
//    @Before
//    public void setUp() throws Exception {
//        pairsProblem = new PairsProblem();
//    }

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