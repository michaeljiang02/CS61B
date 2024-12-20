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
        assertEquals("last", alist1.items[alist1.nextLast - 1]);

        alist1.removeLast();
        assertEquals(1, alist1.size());
        assertEquals("middle", alist1.items[alist1.nextLast - 1]);

        alist1.addFirst("first");
        assertEquals("first", alist1.items[alist1.nextFirst + 1]);

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
        assertEquals(3, alist2.nextFirst);
        assertEquals(4, alist2.nextLast);

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
        assertEquals("middle", alist2.items[alist2.nextLast - 1]);

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
}
