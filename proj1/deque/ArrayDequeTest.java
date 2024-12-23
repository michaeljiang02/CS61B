package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void TestInit() {
        ArrayDeque alist1 = new ArrayDeque();
        assertEquals(0, alist1.size());
    }

    @Test
    public void testAdd() {
        ArrayDeque alist1 = new ArrayDeque();
        alist1.addLast("middle");
        assertEquals(1, alist1.size());
        alist1.addLast("last");
        assertEquals(2, alist1.size());

        alist1.removeLast();
        assertEquals(1, alist1.size());

        alist1.addFirst("first");

        alist1.addFirst("x");
        alist1.addFirst("x");
        alist1.addFirst("x");
        alist1.addLast("x");
        alist1.addLast("x");
        alist1.addLast("x");
    }

    @Test
    public void testFillAndEmptyAndFill() {
        ArrayDeque alist2 = new ArrayDeque();
        alist2.removeFirst();
        alist2.removeLast();
        //Nothing should happen

        alist2.addLast("middle");
        alist2.addLast("last");
        alist2.addFirst("first");
        alist2.removeFirst();

        alist2.addFirst("x");
        alist2.addFirst("x");
        alist2.addFirst("random");
        alist2.addFirst("x");
        alist2.addFirst("x");
        Object last = alist2.removeLast();
        assertEquals("last", last);

        Object item = alist2.get(5);
        Object item2 = alist2.get(2);
        assertEquals("middle", item);
        assertEquals("random", item2);
        alist2.addFirst("x");
        alist2.addFirst("x");
        for (int i = 0; i < 8; i++) {
            alist2.removeFirst();
        }

        alist2.addLast("middle");
        alist2.addLast("last");
        alist2.addLast("first");
        alist2.addLast("x");
        alist2.addLast("x");
        alist2.addLast("random");
        alist2.addLast("x");
        alist2.addLast("x");

        alist2.printDeque();

    }

    @Test
    public void testIterator() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addLast("hello,");
        ad.addLast("my");
        ad.addLast("name");
        ad.addLast("is");
        ad.addLast("Michael");

        for (Object item : ad) {
            System.out.print(item);
        }
    }

    @Test
    public void testResize() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addLast("first");
        for (int i = 0; i < 50; i++) {
            ad.addLast("x");
        }
        ad.addLast("last");
        for (int i = 0; i < 40; i++) {
             ad.removeLast();
        }
    }

    @Test
    public void testEquals() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addLast("hello,");
        ad.addLast("my");
        ad.addLast("name");
        ad.addLast("is");
        ad.addLast("Michael");

        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ad1.addLast("hello,");
        ad1.addLast("my");
        ad1.addLast("name");
        ad1.addLast("is");
        ad1.addLast("Michael");

        assertTrue(ad.equals(ad1));

        ad1.removeLast();
        assertFalse(ad.equals(ad1));
    }
}
