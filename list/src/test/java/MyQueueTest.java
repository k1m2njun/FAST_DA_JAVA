import list.MyArrayList;
import queue.MyQueue;

public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue<String> arr = new MyQueue<>();

        arr.offer("A");
        arr.offer("B");
        arr.offer("C");
        arr.offer("D");
        arr.offer("E");

        System.out.println(arr.peek());

        arr.poll();
        arr.poll();

        System.out.println(arr.peek());


    }
}
