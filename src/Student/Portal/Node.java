package Student.Portal;

public class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) { this.data = data; }

    public Node<E> getNext() { return next; }

    public void setNext(Node<E> next) { this.next = next; }

    public Node<E> getPrev() { return prev; }

    public void setPrev(Node<E> prev) { this.prev = prev; }
}
