import stack.MyStack;

public class MyStackTest {

    public static void main(String[] args) {
        MyStack<String> st = new MyStack<String>();

        st.push("A");
        st.push("B");
        st.push("C");
        st.push("D");
        st.push("E");

        System.out.println(st.peek());

        System.out.println(st.pop());
        System.out.println(st.pop());

        System.out.println(st.peek());
    }
}
