package edu.cscc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


/**
 * Test cases for the {@link ArrayList} class.
 *
 */
public final class ArrayListTest {

    private static ArrayList aList50 = new ArrayList(50);
    private static ArrayList aList25 = new ArrayList(25);
    private static ArrayList aList10 = new ArrayList(10);
    private static ArrayList aList5 = new ArrayList(5);
    private static ArrayList aList0 = new ArrayList(0);


    @Test
    public void size() {
        ArrayList list = new ArrayList();
        assertEquals("Default Size Check",aList50.size(),list.size());
        assertEquals("Size is 50",50, aList50.size());
        assertEquals("Size is 25",25, aList25.size());
        assertEquals("Size is 10",10, aList10.size());
        assertEquals("Size is 5",5, aList5.size());
        assertEquals("Size is 0",1, aList0.size());
    }

    @Test
    public void isEmpty() {
        ArrayList list = new ArrayList();
        list.clear();
        assertTrue("Empty when cleared - Default", list.isEmpty());
    }

    // Failing
    @Test
    public void clear() {
        ArrayList list = new ArrayList();
        Object o = "Hello";

        list.add(o);
        list.clear();
        assertEquals("Object added to the top and cleared", true, list.isEmpty());

        aList0.add(2, o);
        aList50.clear();
        assertEquals("Object added at the index and cleared", true, aList50.isEmpty());
    }

    //Failing
    @Test
    public void add() {
        ArrayList list = new ArrayList();
        Object o = "Hello";

        list.add(o);
        assertEquals("Object added", false, list.isEmpty());

        aList0.add(2, o);
        assertEquals("Object added", false, aList0.isEmpty());

    }

    @Test
    public void get() {
        ArrayList list = new ArrayList();

        Object o = "Hello";
        list.add(0, o);
        aList0.add(0, o);
        Object n = list.get(0);
        Object m = aList0.get(0);

        assertEquals("Added object is not empty",false, list.isEmpty());
        assertEquals("Retrieved object is equal",true, n.equals(o));
        assertEquals("Added object is not empty",false, aList0.isEmpty());
        assertEquals("Retrieved object is equal",true, m.equals(o));
    }

    @Test
    public void remove() {
        ArrayList list = new ArrayList();

        String o = "Hello";
        list.add(0, o);
        aList0.add(0, o);

        assertEquals("Added object is not empty",false, list.isEmpty());
        assertEquals("Added object is not empty",false, aList0.isEmpty());

        list.remove(0);
        aList0.remove(0);

        assertEquals("Object is empty after removing",false, list.isEmpty());
        assertEquals("Object is empty after removing",false, aList0.isEmpty());


    }
}