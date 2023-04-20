package list;

public class MyDoubleLinkedList<T> implements IList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.previous = this.head; // [p[head]n] <=> [p[tail]n]
    }

    @Override
    public void add(T t) {
        Node last = this.tail.previous;
        Node node = new Node(t, last, this.tail);
        last.next = node;
        this.tail.previous = node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        Node previous = null;
        Node current = null;

        int i = 0;
        if(index < (this.size / 2)) {
            previous = this.head;
            current = this.head.next;

            while(i++ < index){
                previous = previous.next;
                current = current.next;
            }
        } else {
            previous = this.tail;
            current = this.tail.previous;

            while(i++ <= (this.size - index)){
                previous = previous.previous;
                current = current.previous;
            }
        }
        Node node = new Node(t, previous, current);
        current.previous = node;
        previous.next = node;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this.tail;
        this.tail.previous = this.head; // [p[head]n] <=> [p[tail]n]
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {

        if(index >= this.size || index < 0) { throw new IndexOutOfBoundsException(); }

        Node previous = null;
        Node current = null;
        Node next = null;

        int i = 0;
        if(index < this.size / 2) { // index가 head에서 더 가까우면
            previous = this.head;
            current = this.head.next;
            while(i++ < index) {
                previous = previous.next;
                current = current.next;
            }
            previous.next = current.next;
            current.next.previous = previous;
            previous.next = null;
        } else { // index가 head에서 더 가까우면
            current = this.tail.previous;
            next = this.tail;
            while(i++ < (this.size - index - 1)) {
                current = current.previous;
                next = next.previous;
            }
            next.previous = current.previous;
            current.previous.next = next;
            current.previous = null;
        }
        current.next = null;
        this.size--;
        return false;
    }

    @Override
    public T get(int index) {
        if(index >= this.size || index < 0) { throw new IndexOutOfBoundsException(); }

        int i = 0;
        Node current = null;
        if(index < this.size / 2) { // index가 head에서 더 가까우면
            current = this.head.next;
            while(i++ < index) {
                current = current.next;
            }
        } else { // index가 head에서 더 가까우면
            current = this.tail.previous;
            while(i++ < (this.size - index - 1)) {
                current = current.previous;
            }
        }
        return current.data;
    }

    @Override
    public int indexOf(T t) {

        Node currentToNext = this.head.next;
        Node currentToPrev = this.tail.previous;

        Node current = this.head.next;
        int index = 0;
        while(current != null) {
            if(t.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        while(index++ <= (this.size / 2)) {
            currentToNext = currentToNext.next;
            currentToPrev = currentToPrev.previous;
            if (currentToNext.data.equals(t)) { return index; }
            if (currentToPrev.data.equals(t)) { return this.size - index; }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public boolean contains(T t) {
        Node currentToNext = this.head.next;
        Node currentToPrev = this.tail.previous;
        int i = 0;
        while(i++ <= (this.size / 2)) {
            currentToNext = currentToNext.next;
            currentToPrev = currentToPrev.previous;
            if(currentToNext.data.equals(t) || currentToPrev.data.equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        T data;
        Node previous;
        Node next;

        Node(T data) { this.data = data; }

        Node(T data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }
}
