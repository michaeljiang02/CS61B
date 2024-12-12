package deque;

public class ArrayDeque<T> {
    T[] items;
    int nextFirst;
    int nextLast;
    int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = increment(nextLast);
        size += 1;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = decrement(nextLast);
        size -= 1;
        return items[nextLast];
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = decrement(nextFirst);
        size += 1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = increment(nextFirst);
        size -= 1;
        return items[nextFirst];
    }

    public T get(int index) {
        int newIndex = nextFirst + 1 + index;
        if (newIndex >= items.length) {
            newIndex -= items.length;
        }
        return items[newIndex];
    }

    private int increment(int i) {
        if (i + 1 == items.length) {
            i = 0;
        } else {
            i += 1;
        }
        return i;
    }

    private int decrement(int i) {
        if (i == 0) {
            i = items.length - 1;
        } else {
            i -= 1;
        }
        return i;
    }

    public void printDeque() {
        int current = increment(nextFirst);
        for (int i = 0; i < this.size; i++) {
            System.out.print(items[current] + " ");
            current = increment(current);
            System.out.println();
        }
    }
}
