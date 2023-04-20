import list.MyDoubleLinkedList;

public class MyDoubleLinkedListTest {

    public static void main(String[] args) {
        MyDoubleLinkedList<String> arr = new MyDoubleLinkedList<>();

        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");
        arr.add("E");
        arr.add("F");
        arr.add("G");
        arr.add("H");

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
        System.out.println();

//        arr.insert(1, "HOHO");
        arr.insert(2, "KILMINJUN");

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
        System.out.println();

        System.out.println(arr.indexOf("KILMINJUN"));

    }
}
