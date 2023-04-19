package list;

public class MyLinkedList<T> implements IList<T>{

    private int size;
    private Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(null); // 더미노드, head는 항상 비어있는 객체가 들어가있어야 한다.
    }

    @Override
    public void add(T t) {
        Node current = this.head;
        while(current.next != null) { // curr이 null이 될 때까지 끝의 노드로 이동
            current = current.next;
        }
        Node node = new Node(t);
        current.next = node; // 즉 현재의 Null(tail)에 새 Node를 추가
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        if(index > this.size || index < 0) {
            throw  new IndexOutOfBoundsException();
        }
        Node previous = this.head;
        Node current = previous.next; // 최초 null

        int i = 0;
        while(i++ < index) {
            previous = previous.next;
            current = current.next;
        }

        Node node = new Node(t, current);
        previous.next = node;
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = null;
    }

    @Override
    public boolean delete(T t) {
        Node previous = this.head;
        Node current = previous.next;

        while(current != null) { // 다음 노드를 탐색하는 구간
            if(current.data.equals(t)) {
                previous.next = current.next;
                current.next = null; // current.next 를 null로 초기화하면, 연결이 끊겨 current는 미아가 된다. 이는 GC가 정리해줌.
                this.size--;
                return true;
            }
            previous = previous.next;
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if(index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node previous = this.head;
        Node current = previous.next;

        int i = 0;
        while(i++ < index) {
            previous = previous.next;
            current = current.next;
        }
        previous.next = current.next;
        current.next = null;
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        Node current = this.head.next; // head.next가 인덱스 0.
        int i = 0;
        while(i++ < index) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int indexOf(T t) {
        Node current = this.head.next;
        int index = 0;
        while(current != null) {
            if(t.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public boolean contains(T t) {
        Node current = this.head.next;
        while(current != null) {
            if(t.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node{
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
