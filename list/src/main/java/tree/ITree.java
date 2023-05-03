package tree;

public interface ITree<T> {
    public void insert(T val);
    public void delete(T val);

    public boolean contains(T val);
    public int size();
}
