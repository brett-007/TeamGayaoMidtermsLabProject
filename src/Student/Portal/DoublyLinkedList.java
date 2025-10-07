package Student.Portal;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A simple implementation of a doubly linked list data structure.
 *
 * <p>This class stores elements in a sequence where each node points
 * to the next and previous node. It supports operations such as insertion,
 * deletion, searching, and retrieval by index.</p>
 *
 * @param <E> the type of elements stored in the list
 */
public class DoublyLinkedList<E> implements MyList<E> {

    Node<E>  head;
    Node<E>  tail;
    int size;
    static Scanner kbd = new Scanner(System.in);

    /**
     * Constructs an empty doubly linked list.
     */
    DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Runs a menu-driven program to demonstrate
     * the functionality of the doubly linked list.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args){
        DoublyLinkedList<Integer> numbers = new DoublyLinkedList<>();

        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(50);
        numbers.insert(60);

        int choice = 0;
        do {
            try {
                System.out.println("\nMy Doubly Linked List Menu: ");
                System.out.println("1. Print Current List");
                System.out.println("2. Print List Size");
                System.out.println("3. Insert New Element");
                System.out.println("4. Get Element at Index");
                System.out.println("5. Delete Element");
                System.out.println("6. Search");
                System.out.println("7. Traverse List:");
                System.out.println("0. Exit");
                System.out.print("Enter Choice: ");

                choice = kbd.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println(numbers.toString());
                        break;
                    case 2:
                        System.out.println(numbers.getSize());
                        break;
                    case 3:
                        kbd.nextLine();
                        System.out.print("Insert New Item: ");
                        int item = kbd.nextInt();
                        if (item == 0) {
                            System.out.println("\nInsert Element Unsuccessful.");
                        } else {
                            numbers.insert(item);
                            System.out.println("\nElement inserted successfully");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Index of Element: ");
                        int index = kbd.nextInt();
                        try {
                            numbers.getElement(index);
                            System.out.println("\nElement found at " + " is: " + numbers.getElement(index));
                        } catch (NoSuchElementException e) {
                            System.out.println("\nElement not Found.");
                        }
                        break;
                    case 5:
                        kbd.nextLine();
                        System.out.print("Enter Element to Delete: ");
                        int deleteElement = kbd.nextInt();
                        if (numbers.delete(deleteElement)) {
                            System.out.println("\n" + deleteElement + " element deleted successfully.");
                        } else {
                            System.out.println("\n" + deleteElement + " element not found.");
                        }
                        break;
                    case 6:
                        kbd.nextLine();
                        System.out.print("Enter Element to Search: ");
                        int searchElement = kbd.nextInt();
                        if (numbers.search(searchElement) == -1) {
                            System.out.println("\n" + searchElement + " element not found.");
                        } else {
                            System.out.println("\n" + searchElement + " element found at index " + numbers.search(searchElement));
                        }
                        break;
                    case 7:
                        int traverseChoice;
                        kbd.nextLine();
                        do {
                            System.out.println("\nTraverse Menu:");
                            System.out.println("\n1. Forward from Head");
                            System.out.println("\n2. Backward from Tail");
                            System.out.println("\n0. Back to Menu");
                            System.out.print("Enter Choice: ");
                            traverseChoice = kbd.nextInt();

                            switch (traverseChoice) {
                                case 1:
                                    numbers.traverseForward();
                                    break;
                                case 2:
                                    numbers.traverseBackward();
                                    break;
                                case 0:
                                    System.out.println("\nReturning to Main Menu.");
                                    break;
                                default:
                                    System.out.println("\nInvalid choice.");
                            }
                        } while (traverseChoice != 0);
                        break;
                    case 0:
                        System.out.println("\nReturning to Launcher.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice. Please Try Again.");
                kbd.nextLine();
                choice = -1;
            }
        } while (choice != 0);

    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    @Override
    public int getSize() {
        System.out.print("");
        return size;
    }

    /**
     * Inserts a new element at the end of the list.
     *
     * @param data the element to insert
     */
    @Override
    public void insert(E data){

        Node<E> newNode = new Node<E>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the position of the element to retrieve
     * @return the element at the given index
     * @throws NoSuchElementException if the index is invalid
     */
    @Override
    public E getElement(int index) throws NoSuchElementException {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index out of Bounds!");
        }

        Node<E>  current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    /**
     * Deletes the first occurrence of the specified element.
     *
     * @param data the element to delete
     * @return {@code true} if the element was found and deleted, {@code false} otherwise
     */
    @Override
    public boolean delete(E data) {

        Node<E>  current = head;

        while (current != null) {
            if (current.data.equals(data)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) tail.next = null;
                    else head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Searches for the specified element and returns its index.
     *
     * @param data the element to search for
     * @return the index of the element if found, or -1 if not found
     */
    @Override
    public int search(E data) {
        Node<E>  current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return the elements in the list as a formatted string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            sb.append(getElement(i)).append("\n");
        }

        return sb.toString();
    }

    public void traverseForward() {
        System.out.println("Forward from Head");
        Node<E>  current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void traverseBackward() {
        System.out.println("Backward from Tail");
        Node<E>  current = tail;
        while (current!= null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }
}

