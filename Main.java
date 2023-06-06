package HW_4;

public class Main {
    public static void main(String[] args) {
        RedBlackTree node = new RedBlackTree();

        node.insert(11);
        node.inorder();
        System.out.println();
        node.insert(22);
        node.inorder();
        System.out.println();
        node.insert(33);
        node.inorder();
        System.out.println();
        node.insert(44);
        node.inorder();
        System.out.println();
        node.insert(-11);
        node.inorder();
        System.out.println();
        node.insert(-22);
        node.inorder();
        System.out.println();
        node.insert(-33);
        node.inorder();
        System.out.println();
        node.insert(-44);
        node.inorder();
    }
}