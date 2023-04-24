package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            q.add(i + 1);
        }

        int count = 1;
        while(q.size() != 1) {
            int qNum = q.poll();
            if (count % 2 == 0) {
                q.offer(qNum);
            }
            count++;
        }
        System.out.println(q.peek());
    }
}
