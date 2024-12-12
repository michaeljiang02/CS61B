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
        incrementLast();
        size += 1;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast -= 1;
        size -= 1;
        return items[nextLast];
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        decrementFirst();
        size += 1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst += 1;
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

    public void incrementLast() {
        if (nextLast + 1 == items.length) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    public void decrementFirst() {
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }

    public void printDeque() {
        int current = nextFirst + 1;
        if (current == items.length) {
            current = 0;
        }
        while (current != nextLast) {
            System.out.print(items[current] + " ");
            if (current + 1 == items.length) {
                current = 0;
            } else { current += 1;}
            System.out.println();
        }
    }
}
