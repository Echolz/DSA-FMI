package utils;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SampleLinkedListTest {
    private LinkedList<Integer> list;
    private java.util.LinkedList<Integer> realList;

    @Before
    public void setUp() {
        list = new LinkedList<>();
        realList = new java.util.LinkedList<>();

        int n = 10;

        for (int i = 0; i < n; i++) {
            list.addLast(i);
            realList.add(i);
        }
    }

    @Test
    public void testAdd_CheckIfSizeIsCorrect() {
        assertEquals(realList.size(), list.getSize());
    }

    @Test
    public void testRemove_DoesNothingWhenAnyFileIsMissing() {
        for (int i = 0; i < list.getSize() / 3; i++) {
            assertEquals(realList.removeLast(), list.removeLast());
        }
        assertEquals(realList.peekLast(), list.seeLast());

        for (int i = 0; i < list.getSize() / 3; i++) {
            assertEquals(realList.removeFirst(), list.removeFirst());
        }
        assertEquals(realList.peekFirst(), list.seeFirst());
        assertEquals(realList.peekLast(), list.seeLast());

        assertEquals(realList.size(), list.getSize());
    }
}
