package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        T maxElement = get(0);
        for (T item : this) {
            if (comparator.compare(item, maxElement) > 0) {
                maxElement = item;
            }
        }
        return maxElement;
    }

    public T max(Comparator<T> c) {
        T maxElement = get(0);
        for (T item : this) {
            if (c.compare(item, maxElement) > 0) {
                maxElement = item;
            }
        }
        return maxElement;
    }

    public static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
}
