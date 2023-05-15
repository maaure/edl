public interface Lista<T> {
    int size();
    boolean isEmpty();
    T first();
    T last();
    T before(Integer i);
    T after(Integer i);
    void replaceElement(Position<T> n, T data);
    void swapElements(Position<T> n, Position<T> q);
    void insertBefore(Position<T> n, T data);
    void insertAfter(Position<T> n, T data);
    void insertFirst(T o);
    void insertLast(T o);
    T remove(Position<T> n);

}