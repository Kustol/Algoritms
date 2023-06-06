package HW_3;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addLast(22);
        list.addLast(44);
        list.addLast(11);
        list.addLast(55);
        list.addLast(33);
        list.printList();

        System.out.println();
        list.BubbleSort();
        list.printList();
        System.out.println();
        list.revert();
        list.printList();
    }


}