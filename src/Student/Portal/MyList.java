package Student.Portal;

import java.util.*;

/**
 * Interface with Abstract Classes used by the Data Structures
 */
public interface MyList<E> {
    public int getSize();
    public void insert(E data);
    public E getElement(int index) throws NoSuchElementException;
    public boolean delete(E data); // returns false if the data is not deleted in the list
    public int search(E data); // returns index of data, else -1 is return
}
