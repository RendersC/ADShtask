public class Main {
    public static void main(String[] args) {
        System.out.println("TEST MyArrayList: ");
        testMyArrayList();

        System.out.println("\n\n\n\nTEST MyLinkedList:");
        testMyLinkedList();
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
}
