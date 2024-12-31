import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCircularLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0; // Number of elements in the list

    // Inner Node class
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    // Add an element to the beginning of the list
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null) // the new node is the only node in the list
            tail = head;
        tail.next = head;
    }

    // Add an element to the end of the list
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in the list
        } else {
            tail.next = newNode; // Link the new node with the last node
            tail = newNode; // Tail now points to the last node
        }
        size++;
    }

    // Add an element at a specific index
    @Override
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    // Get the element at a specific index
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.element;
    }

    // Get the index of a specific element
    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node<E> current = head;

        while (current != null && !current.element.equals(e)) {
            current = current.next;
            index++;
        }

        return (current != null) ? index : -1;
    }

    // Get the last index of a specific element
    @Override
    public int lastIndexOf(E e) {
        int index = -1;
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                index = i;
            }
            current = current.next;
        }

        return index;
    }

    // Remove the element at a specific index
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E removedElement;

        if (index == 0) {
            removedElement = removeFirst();
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            removedElement = current.next.element;
            current.next = current.next.next;
            if (index == size - 1) {
                tail = current;
            }
            size--;
        }

        return removedElement;
    }

    // Set the element at a specific index to a new value
    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E replacedElement = current.element;
        current.element = e;
        return replacedElement;
    }

    // Check if the list contains a specific element
    @Override
    public boolean contains(Object o) {
        Node<E> current = head;

        while (current != null) {
            if (current.element.equals(o)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Get the size of the list
    @Override
    public int size() {
        return size;
    }

    // Convert the list to a string representation
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            result.append(current.element);
            if (i < size - 1) {
                result.append(", ");
            }
            current = current.next;
        }

        result.append("]");
        return result.toString();
    }

    // Clear the list
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // Get the first element in the list
    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return head.element;
    }

    // Get the last element in the list
    public E getLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.element;
    }

    // Remove the first element in the list
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        E removedElement = head.element;
        head = head.next;
        if (size == 1) {
            tail = null;
        } else {
            tail.next = head;
        }
        size--;
        return removedElement;
    }

    // Remove the last element in the list
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        E removedElement;
        if (size == 1) {
            removedElement = head.element;
            head = tail = null;
        } else {
            Node<E> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            removedElement = tail.element;
            tail = current;
            tail.next = head;
        }
        size--;
        return removedElement;
    }

    // Iterator for the list
    @Override
    public Iterator<E> iterator() {
        return new CircularListIterator();
    }

    // Inner iterator class
    private class CircularListIterator implements Iterator<E> {
        private Node<E> current = (tail == null) ? null : tail.next;
        private boolean removeCalled = false;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E data = current.element;
            current = current.next;
            removeCalled = false;
            return data;
        }

        @Override
        public void remove() {
            if (removeCalled) {
                throw new IllegalStateException("remove() can only be called once per next()");
            }

            if (size == 0) {
                throw new IllegalStateException("List is empty");
            }
            Node<E> pred = tail; // predecessor node
            Node<E> current = tail.next; // current node to be removed

            // Loop until we find the node before the current one
            while (pred.next != tail) {
                pred = pred.next;
            }

            // Remove the current node
            pred.next = current.next;

            // Update the tail if the last element is removed
            if (current == tail) {
                tail = (size == 1) ? null : pred;
            }

            size--;
            removeCalled = true;
        }
    }
}