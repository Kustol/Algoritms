package HW_4;

public class HashTable<K, V> {

    private static final int init_basket_count = 16;

    private static final double load_factor = 0.5;
    private int size = 0;

    private void recalculate() {
        basket[] old = baskets;
        baskets = (basket[]) new Object[old.length * 2];
        for (int i = 0; i <= old.length; i++) {
            basket baske = old[i];
            basket.Node new_node = baske.head;
            while (new_node != null) {
                put_out(new_node.value.key, new_node.value.value);
                new_node = new_node.next;
            }
            old[i] = null;
        }
    }

    private basket[] baskets;

    public HashTable() {
        this(init_basket_count);
    }

    public HashTable(int int_size) {
        baskets = (basket[]) new Object[int_size];
    }


    private int calculate_basket_index(K key) {
        return key.hashCode() % baskets.length;
    }


    private class entity {
        private K key;
        private V value;

    }

    private class basket {
        private Node head;

        private class Node {
            private Node next;
            private entity value;

        }

        public V get_basket(K key) {
            Node item = head;
            while (item != null) {
                if (item.value.key.equals(key)) {
                    return item.value.value;
                }
                item = item.next;
            }
            return null;
        }

        public boolean put(entity E) {
            Node node = new Node();
            node.value = E;
            Node item = head;
            if (item != null) {
                while (true) {
                    if (item.value.key.equals(E.key)) {
                        return false;
                    }
                    if (item.next == (null)) {
                        item.next = node;
                        return true;
                    }
                    item = item.next;
                }
            }
            head = node;
            return true;
        }

        public boolean remove(K key) {
            if (head != null) {
                if (head.value.key.equals(key)) {
                    head = head.next;
                    return true;
                } else {
                    Node node = head;
                    while (node.next != null) {
                        if (node.next.value.key.equals(key)) {
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                }
            }
            return false;
        }
    }

    public V get_basket_out(K key) {
        int index = calculate_basket_index(key);
        basket basket = baskets[index];

        if (basket != null) {
            return basket.get_basket(key);
        }
        return null;
    }

    public boolean put_out(K key, V value) {
        if (baskets.length * load_factor < size) {
            recalculate();
        }
        int index = calculate_basket_index(key);
        basket baske = baskets[index];
        if (baske == null) {
            baske = new basket();
            baskets[index] = baske;
        }

        entity E = new entity();
        E.key = key;
        E.value = value;
        boolean add = baske.put(E);
        if (add) {
            size++;
        }
        return add;
    }


    public boolean remove_out(K key) {
        int index = calculate_basket_index(key);
        basket baske = baskets[index];
        boolean delete = baske.remove(key);
        if (delete) {
            size--;
        }
        return delete;
    }
}
