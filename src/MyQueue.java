public class MyQueue<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T first = list.getFirst();
        list.removeFirst();
        return first;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T el : list) {
            sb.append(el).append(", ");
        }
        if (list.size() > 0) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
