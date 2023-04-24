package hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ1920 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
//        int[] A = new int[N];
        Set<Integer> A = new HashSet<>();

        for(int i = 0; i < N; i++) {
//            A[i] = scanner.nextInt();
            A.add(scanner.nextInt());
        }

//        StringBuilder result = new StringBuilder();

        int M = scanner.nextInt();
//        int[] B = new int[M];

        for(int i = 0; i < M; i++) {
            int result = 0;
//            B[i] = scanner.nextInt();
            int m = scanner.nextInt();
//            for(int j = 0; j < N; j++) {
//                if(B[i] == A[j]) {
//                    result++;
//                }
//            }
            if(A.contains(m)) {
                result++;
            }

//            if(A.contains(m)) {
//                result.append(1 + "\n");
//            } else {
//                result.append(0 + "\n");
//            }
//            System.out.println(result.toString());
            System.out.println(result);
        }
    }
}
