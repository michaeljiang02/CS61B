package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    public class ItemNode {
        T item;
        ItemNode next;
        ItemNode prev;

        private ItemNode(ItemNode prev, T i, ItemNode next) {
            this.prev = prev;
            item = i;
            this.next = next;
        }
    }

    private ItemNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T i) {
        sentinel.next.prev = new ItemNode(sentinel, i, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    @Override
    public void addLast(T i) {
        sentinel.prev.next = new ItemNode(sentinel.prev, i, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    @Override
    public void printDeque() {
        ItemNode current = sentinel;
        while (current.next.item != null) {
            System.out.print(current.next.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        ItemNode first = sentinel.next;
        if (first.item == null) {
            return null;
        }
        T item = first.item;
        first.next.prev = sentinel;
        sentinel.next = first.next;
        size -= 1;

        return item;
    }

    @Override
    public T removeLast() {
        ItemNode last = sentinel.prev;
        if (last.item == null) {
            return null;
        }
        T item = last.item;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size -= 1;

        return item;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Choose appropriate index");
        }
        ItemNode current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public T getRecursive(int index) {
        return recursiveHelper(sentinel.next, index);
    }

    private T recursiveHelper(ItemNode node, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Choose appropriate index");
        } else if (index == 0) {
            return node.item;
        }
        return recursiveHelper(node.next, index - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Deque) {
            Deque otherDeque = (Deque) o;
            if (this.size() == otherDeque.size()) {
                int index = 0;
                for (T item : this) {
                    if (!item.equals(otherDeque.get(index))) {
                        return false;
                    }
                    index += 1;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private ItemNode current;

        LinkedListIterator() {
            current = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return current.item != null;
        }

        @Override
        public T next() {
            T returnItem = current.item;
            current = current.next;
            return returnItem;
        }
    }
}
