package stack;

import java.util.Scanner;
import java.util.Stack;

public class boj9012 {

    public static void foo(String s) {
        Stack<Character> st = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if(c == '(') {
                st.push(c);
            } else {
                if ( st.size() < 1) {
                    System.out.println("NO");
                    return;
                }
                st.pop();
            }
            i++;
        }
        if (st.size() > 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            foo(scanner.next());
        }
    }
}
