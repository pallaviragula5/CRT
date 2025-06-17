class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeTraversal {

    // Inorder Traversal: Left -> Root -> Right
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder Traversal: Left -> Right -> Root
    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        // Creating the binary tree
        TreeTraversal tree = new TreeTraversal();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Inorder traversal: ");
        tree.inorder(root); // Output: 4 2 5 1 3

        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(root); // Output: 4 5 2 3 1
    }
}
