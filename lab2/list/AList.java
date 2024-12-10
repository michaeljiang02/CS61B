public class Alist {
    private int size;
    private int[] items;

    public Alist() {
        items = new int[100];
        size = 0;
    }

    public void addLast(int x) {
        items[size] = x;
        size += 1;
    }

    public int getLast() {
        return items[size - 1];
    }

    public int get(int i) {
        return items[i];
    }

    public void removeLast() {
        int[] temp = new int[size-1];
        System.arraycopy(items, 0, temp, 0, size - 1);
        size -= 1;
        items = temp;
    }
}
