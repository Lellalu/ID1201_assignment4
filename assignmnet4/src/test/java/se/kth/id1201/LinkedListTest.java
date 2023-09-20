package se.kth.id1201;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.kth.id1201.LinkedList;

/**
 * Unit test for simple App.
 */
public class LinkedListTest 
{
    @Test
    public void addTest()
    {
        int insertedValue = 100;
        int listLength = 10;
        LinkedList l = new LinkedList(listLength);
        l.add(insertedValue);
        assertEquals(insertedValue, l.first.val);
    }
    
    @Test
    public void lengthTest()
    {
        int listLength = 10;
        LinkedList l = new LinkedList(listLength);
        assertEquals(listLength, l.length());
    }

    @Test
    public void findSuccessTest()
    {
        int insertedValue = 100;
        int listLength = 10;
        LinkedList l = new LinkedList(listLength);
        l.add(insertedValue);
        assertTrue(l.find(insertedValue));
    }

    @Test
    public void findFailTest()
    {
        int notExistValue = -1;
        int listLength = 10;
        LinkedList l = new LinkedList(listLength);
        assertFalse(l.find(notExistValue));
    }

    @Test
    public void removeSuccessTest()
    {
        int existValue = 9;
        int listLength = 10;
        LinkedList l = new LinkedList(listLength);
        l.remove(existValue);
        assertFalse(l.find(existValue));
    }

    @Test
    public void removeNonExistentTest()
    {
        int NonExistValue = -1;
        int listLength = 10;
        LinkedList l = new LinkedList(listLength);
        l.remove(NonExistValue);
        assertEquals(listLength, l.length());
    }

    @Test
    public void appendTest()
    {
        int firstListLength = 10;
        int secondListLength = 20;
        LinkedList l1 = new LinkedList(firstListLength);
        LinkedList l2 = new LinkedList(secondListLength);
        l1.append(l2);
        assertEquals(firstListLength+secondListLength, l1.length());
    }

    @Test
    public void appendNullTest()
    {
        int firstListLength = 0;
        int secondListLength = 20;
        LinkedList l1 = new LinkedList(firstListLength);
        LinkedList l2 = new LinkedList(secondListLength);
        l1.append(l2);
        assertEquals(firstListLength+secondListLength, l1.length());
    }

    @Test
    public void pushSuccessTest()
    {
        int value = 100;
        int Length = 0;
        LinkedList l = new LinkedList(Length);
        l.pushFirst(value);
        assertEquals(1, l.length());

    }

    @Test
    public void popSuccessTest()
    {
        int value = 100;
        int length = 0;
        LinkedList l = new LinkedList(length);
        l.pushFirst(value);
        int actual = l.popFirst();
        assertEquals(100, actual);

        length = 10;
        l = new LinkedList(length);
        l.pushFirst(value);
        actual = l.popFirst();
        assertEquals(100, actual);
    }
}
