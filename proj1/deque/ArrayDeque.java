package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = incrementIndex(nextLast, 1);
        size += 1;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size < 0.25 * items.length && items.length >= 16) {
            resize(items.length / 2);
        }
        nextLast = decrementIndex(nextLast, 1);
        size -= 1;
        return items[nextLast];
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = decrementIndex(nextFirst, 1);
        size += 1;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (size <= 0.25 * items.length && items.length >= 16) {
            resize(items.length / 2);
        }
        nextFirst = incrementIndex(nextFirst, 1);
        size -= 1;
        return items[nextFirst];
    }

    public T get(int index) {
        int newIndex = incrementIndex(nextFirst, index + 1);
        return items[newIndex];
    }

    private int incrementIndex(int index, int i) {
        return (index + i) % items.length;
    }

    private int decrementIndex(int index, int i) {
        return (index - i + items.length) % items.length;
    }

    @Override
    public void printDeque() {
        int current = incrementIndex(nextFirst, 1);
        for (int i = 0; i < this.size; i++) {
            System.out.print(items[current] + " ");
            current = incrementIndex(current, 1);
        }
        System.out.println();
    }

    private void resize(int capacity) {
        T[] resizedArray = (T[]) new Object[capacity];
        int index = 0;
        for (Object item : this) {
            resizedArray[index] = (T) item;
            index += 1;
        }
        items = resizedArray;
        nextFirst = decrementIndex(0, 1);
        nextLast = size;

    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int current;
        private int index;

        public ArrayIterator() {
            current = incrementIndex(nextFirst, 1);
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T returnItem = items[current];
            current = incrementIndex(current, 1);
            index += 1;
            return returnItem;
        }
    }
}
