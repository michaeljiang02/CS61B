package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.value.IntegerRange;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> buggy = new BuggyAList<>();
        AListNoResizing<Integer> working = new AListNoResizing<>();
        for (int i = 0; i < 3; i++) {
            buggy.addLast(i);
            working.addLast(i);
        }
        buggy.removeLast();
        working.removeLast();
        assertEquals(buggy.getLast(), working.getLast());

        buggy.removeLast();
        working.removeLast();
        assertEquals(buggy.getLast(), working.getLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                assertEquals(B.size(), L.size());
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    assertEquals(L.getLast(), B.getLast());
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    L.removeLast();
                    B.removeLast();
                }
            }
        }
    }
}
