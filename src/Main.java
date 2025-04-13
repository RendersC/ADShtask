public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        System.out.println("Add elements:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addLast(40);
        list.add(2, 15);
        printList(list);

        System.out.println("\n Get elements:");
        System.out.println("Element with 2 index: " + list.get(2));
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        System.out.println("\nremove elements:");
        list.remove(2);
        list.removeFirst();
        list.removeLast();
        printList(list);

        System.out.println("\nCheck is exist:");
        System.out.println("Is exist 20: " + list.exists(20));
        System.out.println("20-index: " + list.indexOf(20));
        System.out.println("Last index 20: " + list.lastIndexOf(20));

        System.out.println("\n Array:");
        Object[] arr = list.toArray();
        for (Object el : arr) {
            System.out.print(el + " ");
        }

        System.out.println("\n\nSORT elements:");
        list.add(3);
        list.add(1);
        list.sort();
        printList(list);

        System.out.println("\n Clear elements:");
        list.clear();
        printList(list);
    }

    public static void printList(MyList<?> list) {
        System.out.print("List: ");
        for (Object el : list) {
            System.out.print(el + " ");
        }
        System.out.println(" (SIZE: " + list.size() + ")");
    }
}
