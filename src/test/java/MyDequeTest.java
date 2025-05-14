import org.example.Deque;
import org.example.MyDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class MyDequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    public void setUp() {
        deque = new MyDeque<>();
    }

    @Test
    public void testAddFirst() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(3, deque.size());
        assertEquals(3, deque.getFirst());
    }

    @Test
    public void testAddLast() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());
        assertEquals(3, deque.getLast());
    }

    @Test
    public void testRemoveFirst() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(3, deque.removeFirst());
        assertEquals(2, deque.size());
    }

    @Test
    public void testRemoveLast() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.removeLast());
        assertEquals(2, deque.size());
    }

    @Test
    public void testGetFirst() {
        deque.addFirst(1);
        assertEquals(1, deque.getFirst());
    }

    @Test
    public void testGetLast() {
        deque.addLast(1);
        assertEquals(1, deque.getLast());
    }

    @Test
    public void testAddAll() {
        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 5);
        deque.addAll(collection);
        assertEquals(5, deque.size());
        assertTrue(deque.contains(3));
    }

    @Test
    public void testRemoveElement() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertTrue(deque.remove(2));
        assertEquals(2, deque.size());
        assertFalse(deque.contains(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, deque.size());
        deque.addFirst(1);
        assertEquals(1, deque.size());
    }

    @Test
    public void testContains() {
        deque.addFirst(1);
        deque.addFirst(2);
        assertTrue(deque.contains(1));
        assertFalse(deque.contains(3));
    }
}
