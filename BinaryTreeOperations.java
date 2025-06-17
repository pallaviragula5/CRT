class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTreeOperations {

    // Inorder traversal: Left -> Root -> Right
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder traversal: Root -> Left -> Right
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder traversal: Left -> Right -> Root
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Count total nodes
    int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Count leaf nodes
    int countLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    // Find maximum value in the tree
    int findMax(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);
        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    // Calculate height of the tree
    int calculateHeight(Node node) {
        if (node == null) return 0;
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Sum of all nodes
    int sumNodes(Node node) {
        if (node == null) return 0;
        return node.data + sumNodes(node.left) + sumNodes(node.right);
    }

    public static void main(String[] args) {
        /*
                 10
                /  \
               5    20
              / \   /
             3   7 15
        */
        BinaryTreeOperations tree = new BinaryTreeOperations();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(15);

        System.out.print("Inorder Traversal: ");
        tree.inorder(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorder(root);
        System.out.println();

        System.out.println("Total Nodes: " + tree.countNodes(root));
        System.out.println("Leaf Nodes: " + tree.countLeafNodes(root));
        System.out.println("Maximum Value: " + tree.findMax(root));
        System.out.println("Tree Height: " + tree.calculateHeight(root));
        System.out.println("Sum of All Nodes: " + tree.sumNodes(root));
    }
}
