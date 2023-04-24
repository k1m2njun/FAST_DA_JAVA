package hash;
public interface IHashTable<K, V> {

    void put(K k, V v);
    V get(K k);
    boolean delete(K k);
    boolean contains(K k);
    int size();

}
