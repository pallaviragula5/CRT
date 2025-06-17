class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTreeHeight {

    // Method to calculate the height of the tree
    int calculateHeight(Node node) {
        if (node == null)
            return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
        */
        BinaryTreeHeight tree = new BinaryTreeHeight();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int height = tree.calculateHeight(root);
        System.out.println("Height of the binary tree: " + height);
    }
}
