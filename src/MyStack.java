public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty!!");
        T last = list.getLast();
        list.removeLast();
        return last;
    }


    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty!!!");
        return list.getLast();
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
