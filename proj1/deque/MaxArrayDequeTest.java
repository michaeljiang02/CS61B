package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void testMaxInt() {
        Comparator<Integer> intComparator = Comparator.naturalOrder();
        MaxArrayDeque<Integer> intArray = new MaxArrayDeque<>(intComparator);
        intArray.addLast(2);
        intArray.addLast(6);
        intArray.addLast(3);

        assertTrue(intArray.max().equals(6));

        intArray.addLast(9);
        assertTrue(intArray.max().equals(9));
    }

    @Test
    public void testMaxString() {
        Comparator<String> strComparator = new MaxArrayDeque.StringComparator();
        MaxArrayDeque<String> strArray = new MaxArrayDeque<>(strComparator);
        strArray.addLast("hello,");
        strArray.addLast("my");
        strArray.addLast("Michael");
        strArray.addLast("name");
        strArray.addLast("is");

        assertTrue(strArray.max().equals("Michael"));
        strArray.addLast("electroenciphanogramme");

        assertTrue(strArray.max().equals("electroenciphanogramme"));
    }
}
