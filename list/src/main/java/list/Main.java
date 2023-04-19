package list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 리스트 생성
        List<String> list = new ArrayList<>();

        // 리스트에 요소 추가
        list.add("Hello");
        list.add("World");
        list.add("GRACE");

        System.out.println(list);

        // 리스트에서 요소 삭제
        list.remove("Hello");

        System.out.println(list);

        // 리스트에서 인덱스로 요소 추출
        System.out.println(list.get(0));


    }
}