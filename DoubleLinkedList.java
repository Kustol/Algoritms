package HW_3;

public class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList() {
    }

    public void printList() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.value + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    private class Node {
        private Node next;
        private Node previous;
        private int value;
    }

    public void addFirst(int value) {
        Node first = new Node();
        first.value = value;
        if (head != null) {
            first.next = head;
            head.previous = first;
        } else {
            tail = first;
        }
        head = first;
    }

    public void deleteFirst() {
        if (head != null && head.next != null) {
            head = head.next;
            head.previous = null;
        } else {
            head = null;
            tail = null;
        }
    }

    public boolean ifFind(int value) {
        Node i = head;
        while (i != null) {
            if (i.value == value) {
                return true;
            }
            i = i.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node last = new Node();
        last.value = value;
        if (tail != null) {
            last.previous = tail;
            tail.next = last;
        } else {
            head = last;
        }
        tail = last;
    }

    public void deleteLast() {
        if (head != null && head.next != null) {
            tail = tail.previous;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
    }

    public void BubbleSort() {
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            Node i = head;
            while (i != null && i.next != null) {
                if (i.value > i.next.value) {
                    int temp = i.value;
                    i.value = i.next.value;
                    i.next.value = temp;
                    needSort = true;
                }
                i = i.next;
            }
        }
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next1 = currentNode.next;
            Node previous2 = currentNode.previous;
            currentNode.next = previous2;
            currentNode.previous = next1;
            if (previous2 == null) {
                tail = currentNode;
            }
            if (next1 == null){
                head = currentNode;
            }
            currentNode = next1;
        }
    }

    public void revertMine() {
        Node i = head;
        Node j = head;
        Node end = tail;
        while (j != null && j.next != null) {
            while (i != null && i.next != null && i != end) {
                int temp = i.value;
                i.value = i.next.value;
                i.next.value = temp;

                i = i.next;
            }
            i = head;
            end = end.previous;
            j = j.next;
        }
    }
}