package hash;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        // Key, Value
        map.put("Hello", "World");
        map.put("ABC", "DEF");
        map.put("Computer", "Science");

        // 키
        System.out.println(map.get("Hello"));
        System.out.println(map.get("ABC"));
        System.out.println(map.get("Computer"));
        System.out.println();

        System.out.println("Hello".hashCode());
        System.out.println("World".hashCode());
        System.out.println("Hello".hashCode());
        System.out.println("xxxx".hashCode());


    }
}
