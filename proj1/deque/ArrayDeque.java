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
        nextLast = increment(nextLast, 1);
        size += 1;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = decrement(nextLast, 1);
        size -= 1;
        return items[nextLast];
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = decrement(nextFirst, 1);
        size += 1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = increment(nextFirst, 1);
        size -= 1;
        return items[nextFirst];
    }

    public T get(int index) {
        int newIndex = increment(nextFirst, index + 1);
        return items[newIndex];
    }

    private int increment(int index, int i) {
        return (index + i) % items.length;
    }
    private int decrement(int index, int i) {
        int newIndex = index - i;
        if (newIndex < 0) {
            newIndex += items.length;
        }
        return newIndex;
    }

    public void printDeque() {
        int current = increment(nextFirst, 1);
        for (int i = 0; i < this.size; i++) {
            System.out.print(items[current] + " ");
            current = increment(current, 1);
            System.out.println();
        }
    }
}
