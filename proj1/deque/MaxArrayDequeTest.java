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

}
