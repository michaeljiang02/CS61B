package deque;

public class LinkedListDeque<Item> {

    public class ItemNode {
        Item item;
        ItemNode next;
        ItemNode prev;

        public ItemNode(ItemNode prev, Item i, ItemNode next) {
            this.prev = prev;
            item = i;
            this.next = next;
        }
    }

    ItemNode sentinel;
    int size;

    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(Item i) {
        sentinel = new ItemNode(null, null, null);
        sentinel.next = new ItemNode(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item i) {
        sentinel.next.prev = new ItemNode(sentinel, i, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    public void addLast(Item i) {
        sentinel.prev.next = new ItemNode(sentinel.prev, i, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public void printDeque() {
        ItemNode current = sentinel;
        while (current.next.item != null) {
            System.out.print(current.next.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Item removeFirst() {
        ItemNode first = sentinel.next;
        if (first.item == null) {
            return null;
        }
        Item item = first.item;
        first.next.prev = sentinel;
        sentinel.next = first.next;
        size -= 1;

        return item;
    }

    public Item removeLast() {
        ItemNode last = sentinel.prev;
        if (last.item == null) {
            return null;
        }
        Item item = last.item;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size -= 1;

        return item;
    }
}
