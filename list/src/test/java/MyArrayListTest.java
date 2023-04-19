import list.MyArrayList;

public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }

        arr.insert(1, "HOHO");

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }

    }
}
