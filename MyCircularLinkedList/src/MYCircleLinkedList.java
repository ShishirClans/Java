/*import java.util.NoSuchElementException;

public class MyCircularLinkedList<E> implements MyList<E> {
    private Node<E> tail;
    private int size = 0;

    public MyCircularLinkedList() {
        tail = null;
    }

    public MyCircularLinkedList(E[] objs) {
        for (E obj : objs) add(obj);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == 0) addFirst(e);
        else if (index == size) addLast(e);
        else {
            Node<E> current = tail.next;
            for (int i = 1; i < index; i++) current = current.next;

            current.next = new Node<>(e, current.next);
            size++;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        return (index == 0) ? getFirst() : getNode(index).element;
    }

    public int indexOf(Object e) {
        Node<E> current = tail;
        for (int i = 0; i < size; i++) {
            current = current.next;
            if (e.equals(current.element)) return i;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        Node<E> current = tail;
        int save = -1;
        for (int i = 0; i < size; i++) {
            current = current.next;
            if (e.equals(current.element)) save = i;
        }
        return save;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> current = tail.next;
            for (int i = 0; i < index - 1; i++) current = current.next;

            Node<E> temp = current.next;
            current.next = temp.next;
            size--;
            return temp.element;
        }
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<E> current = getNode(index);
        E oldValue = current.element;
        current.element = e;
        return oldValue;
    }

    public boolean contains(Object e) {
        Node<E> current = tail.next;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) return true;
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = tail.next;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (i < size - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }

    public void clear() {
        size = 0;
        tail = null;
    }

    public void addFirst(E e) {
        tail = (size == 0) ? new Node<>(e) : new Node<>(e, tail.next);
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.next;
    }

    public E getFirst() {
        if (size == 0) throw new NoSuchElementException();
        return tail.next.element;
    }

    public E getLast() {
        if (size == 0) throw new NoSuchElementException();
        return tail.element;
    }

    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();

        Node<E> temp = tail.next;
        if (size == 1) tail = null;
        else tail.next = temp.next;

        size--;
        return temp.element;
    }

    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();

        Node<E> current = tail;
        for (int i = 1; i < size - 1; i++) current = current.next;

        Node<E> temp = tail;
        current.next = tail.next;
        tail = current;
        size--;
        return temp.element;
    }

    private Node<E> getNode(int index) {
        Node<E> current = tail.next;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this(element, null);
        }

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}*/
