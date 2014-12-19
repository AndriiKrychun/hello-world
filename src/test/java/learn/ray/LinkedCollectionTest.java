package learn.ray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LinkedCollectionTest {
    LinkedCollection list;


    @Before
    public void setUp() throws Exception {
        list=new LinkedCollection();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");
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
    public void testRemove() throws Exception{
        list.remove("Second");
        Assert.assertEquals(list.size(),4);
    }
}