public class MyLinkedList<T> implements MyList<T> {
    private static class Node<T> {
        T data;
        Node<T> prev, next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(int index, T item) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node<T> current = node(index);
            Node<T> newNode = new Node<>(item);
            Node<T> prev = current.prev;

            newNode.prev = prev;
            newNode.next = current;
            prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    @Override
    public void set(int index, T item) {
        checkElementIndex(index);
        node(index).data = item;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IndexOutOfBoundsException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IndexOutOfBoundsException("List is empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);
        unlink(node(index));
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IndexOutOfBoundsException("List is empty");
        unlink(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IndexOutOfBoundsException("List is empty");
        unlink(tail);
    }

    private void unlink(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (prev == null) head = next;
        else prev.next = next;

        if (next == null) tail = prev;
        else next.prev = prev;

        size--;
    }

    @Override
    public boolean exists(Object item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Object item) {
        int index = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            if (x.data.equals(item)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        int index = size - 1;
        for (Node<T> x = tail; x != null; x = x.prev) {
            if (x.data.equals(item)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            arr[i++] = x.data;
        }
        return arr;
    }

    @Override
    public void sort() {
        if (size < 2) return;

        Object[] arr = this.toArray();
        java.util.Arrays.sort(arr);
        clear();
        for (Object item : arr) {
            addLast((T) item);
        }
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> node(int index) {
        Node<T> x;
        if (index < (size / 2)) {
            x = head;
            for (int i = 0; i < index; i++) x = x.next;
        } else {
            x = tail;
            for (int i = size - 1; i > index; i--) x = x.prev;
        }
        return x;
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
