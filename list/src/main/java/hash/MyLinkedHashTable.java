package hash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class MyLinkedHashTable<K, V> implements IHashTable<K, V> {

    private static final int DEFAULT_BUCKET_SIZE = 1024;

    private List<Node>[] buckets;
    private int size;
    private int bucketSize;
    public MyLinkedHashTable() {
        this.buckets = new List[DEFAULT_BUCKET_SIZE];
        this.bucketSize = DEFAULT_BUCKET_SIZE;
        this.size = 0;

        for(int i = 0; i < bucketSize; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }
    public MyLinkedHashTable(int bucketSize) {
        this.buckets = new List[bucketSize];
        this.bucketSize = bucketSize;
        this.size = 0;

        for(int i = 0; i < bucketSize; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }
    @Override
    public void put(K k, V v) {
        int idx = this.hash(k);
        List<Node> bucket = this.buckets[idx];
        for(Node node : bucket) {
            if(node.key.equals(k)) {
                node.value = v;
                return;
            }
        }
        Node node = new Node(k, v);
        bucket.add(node);
        this.size++;
    }
    @Override
    public V get(K k) {
        int idx = this.hash(k);
        List<Node> bucket = this.buckets[idx];
        for(Node node : bucket) {
            if(node.key.equals(k)) {
                return node.value;
            }
        }
        return null;
    }
    @Override
    public boolean delete(K k) {
        int idx = this.hash(k);
        List<Node> bucket = this.buckets[idx];
        for(Iterator<Node> iter = bucket.iterator(); iter.hasNext();) {
            Node node = iter.next();
            if(node.key.equals(k)) {
                iter.remove();
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(K k) {
        int idx = this.hash(k);
        List<Node> bucket = this.buckets[idx];
        for(Node node : bucket) {
            if(node.key.equals(k)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int size() {
        return this.size;
    }
    private int hash(K k) {
        int hash = 0;
        for (Character ch : k.toString().toCharArray()) {
            hash += (int) ch; // 문자를 아스키 int 값으로 변환해 hash에 더해준다.
        }
        return hash % this.bucketSize; // bucketSize보다 작은 값이 나오도록 만듦.
    }
    private class Node {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
