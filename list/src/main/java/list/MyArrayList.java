package list;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T> {

    private static final int DEFAULT_SIZE = 50;
    private int size;
    private T[] elements;

    public MyArrayList(){
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T t) {
        if(this.size == this.elements.length){ // 기존 배열이 꽉차면 배열의 크기를 늘려주면서 복사한다.
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }
        this.elements[this.size++] = t;
    }

    @Override
    public void insert(int index, T t) {
        if(this.size == this.elements.length) { // 기존 배열이 꽉차면 배열의 크기를 늘려주면서 복사한다.
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }
        for(int i = index; i < this.size; i++){ // 요소를 삽입할 때 index 위치에서부터 뒤로 밀어야함.
            this.elements[i + 1] = this.elements[i]; // ?? 뒤에서부터 땡겨야되는 거 아님 ? 이렇게 되면 최초 i가 계속 복사되잖아.
        }
        this.elements[index] = t;
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean delete(T t) {
        for(int i = 0; i < this.size; i++) {
            if(this.elements[i].equals(t)){
                for(int j = i; j < this.size - 1; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if(index < 0 || index > this.size - 1) { return false; } // 인덱스를 잘못 입력하는 경우
        for(int i = index; i < this.size - 1; i++) { // 인덱스 뒤부터 앞으로 한 칸씩 당겨와야함
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > this.size - 1) { throw new IndexOutOfBoundsException(); } // 인덱스를 잘못 입력하는 경우
        return this.elements[index];
    }

    @Override
    public int indexOf(T t) {
        for (int i = 0; i < this.size; i++){
            if(this.elements[i].equals(t)){
                return i;
            }
        }
        return -1; // 실제 존재하지 않는 인덱스값으로 출력
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) {
        for(int i = 0; i < this.size; i++){
            if(this.elements[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
