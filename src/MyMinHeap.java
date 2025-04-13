import java.util.ArrayList;
import java.util.List;

public class MyMinHeap<T extends Comparable<T>> {
    private final List<T> heap;

    public MyMinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty!");
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty!");
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIdx = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIdx)) < 0) {
                swap(index, parentIdx);
                index = parentIdx;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        int left, right, smallest;

        while (index < heap.size()) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
