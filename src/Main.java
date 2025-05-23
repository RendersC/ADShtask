public class Main {
    public static void main(String[] args) {
        System.out.println("TEST MyArrayList: ");
        testMyArrayList();

        System.out.println("\n\n\n\nTEST MyLinkedList: ");
        testMyLinkedList();

        System.out.println("\n\n TEST MyStack: ");
        testMyStack();

        System.out.println("\n\n\n TEST MyQueue");
        testMyQueue();

        System.out.println("\n\n\n TEST MyMinHeap");
        testMyMinHeap();
    }

    public static void testMyArrayList() {
        MyList<Integer> list = new MyArrayList<>();

        System.out.println("\nAdd elements:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addLast(40);
        list.add(2, 15);
        printList(list);

        System.out.println("\nGet elements:");
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        System.out.println("\nRemove elements:");
        list.remove(2);
        list.removeFirst();
        list.removeLast();
        printList(list);

        System.out.println("\nCheck existence:");
        System.out.println("Contains 20? " + list.exists(20));
        System.out.println("Index of 20: " + list.indexOf(20));
        System.out.println("Last index of 20: " + list.lastIndexOf(20));

        System.out.println("\nTo array:");
        Object[] arr = list.toArray();
        for (Object el : arr) {
            System.out.print(el + " ");
        }

        System.out.println("\n\nSort elements:");
        list.add(3);
        list.add(1);
        list.sort();
        printList(list);

        System.out.println("\nClear elements:");
        list.clear();
        printList(list);
    }

    public static void testMyLinkedList() {
        MyList<Integer> list = new MyLinkedList<>();

        System.out.println("\nAdd elements:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addLast(40);
        printList(list);

        System.out.println("\n add by index:");
        list.add(2, 15);
        printList(list);

        System.out.println("\n Getting elements:");
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("in 3 position: " + list.get(3));

        System.out.println("\n Remove elements:");
        list.removeFirst();
        list.removeLast();
        list.remove(2);
        printList(list);

        System.out.println("\n Check existence:");
        System.out.println("Exist 15? " + list.exists(15));
        System.out.println("Index 30: " + list.indexOf(30));
        System.out.println("Last index 15: " + list.lastIndexOf(15));
        System.out.println("SIZE: " + list.size());

        System.out.println("\n Sorting elements:");
        list.add(25);
        list.add(5);
        list.sort();
        printList(list);

        System.out.println("\n clear elements:");
        list.clear();
        System.out.println("Size after clearing: " + list.size());
    }

    public static void printList(MyList<?> list) {
        System.out.print("List: ");
        for (Object el : list) {
            System.out.print(el + " ");
        }
        System.out.println(" (SIZE: " + list.size() + ")");
    }


    public static void testMyStack() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);

        System.out.println("Size: " + stack.size());
        System.out.println("Is empty? " + stack.isEmpty());

        stack.pop();
        stack.pop();
        System.out.println("Is empty after clearing? " + stack.isEmpty());
    }


    public static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue: " + queue);

        System.out.println("Peek: " + queue.peek());  // 1
        System.out.println("Dequeue: " + queue.dequeue()); // 1
        System.out.println("After dequeue: " + queue); // 2, 3

        System.out.println("Size: " + queue.size()); // 2
        System.out.println("Is empty? " + queue.isEmpty()); // false

        queue.dequeue();
        queue.dequeue();
        System.out.println("Is empty after clearing? " + queue.isEmpty()); // true
    }


    public static void testMyMinHeap() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        heap.insert(10);
        heap.insert(4);
        heap.insert(7);
        heap.insert(2);
        heap.insert(5);

        System.out.println("Heap: " + heap);         // [2, 4, 7, 10, 5]
        System.out.println("Peek: " + heap.peek());  // 2

        System.out.println("Extract Min: " + heap.extractMin()); // 2
        System.out.println("Heap after extract: " + heap);        // [4, 5, 7, 10]
    }

}
