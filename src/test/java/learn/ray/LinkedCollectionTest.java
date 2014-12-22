package learn.ray;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;


@RunWith(Parameterized.class)
public class LinkedCollectionTest {

    @Parameterized.Parameter
    public Collection list = new LinkedCollection();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new LinkedCollection()});
        return params;
    }


    @Before
    public void setUp() throws Exception {
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");
    }

    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertTrue(list.contains("Third"));
    }

    @Test
    public void testDoesNotContain() throws Exception {
        Assert.assertFalse(list.contains("someshit"));
    }

    @Test
    public void testRemove() throws Exception {
        list.remove("Second");
        Assert.assertEquals(list.size(), 4);
    }


}