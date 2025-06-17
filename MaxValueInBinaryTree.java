class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class MaxValueInBinaryTree {

    // Recursive method to find maximum value
    int findMax(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int maxLeft = findMax(node.left);
        int maxRight = findMax(node.right);

        return Math.max(node.data, Math.max(maxLeft, maxRight));
    }

    public static void main(String[] args) {
        /*
                 10
                /  \
               25   15
              /    /  \
             5    30   20
        */
        MaxValueInBinaryTree tree = new MaxValueInBinaryTree();
        Node root = new Node(10);
        root.left = new Node(25);
        root.right = new Node(15);
        root.left.left = new Node(5);
        root.right.left = new Node(30);
        root.right.right = new Node(20);

        int maxValue = tree.findMax(root);
        System.out.println("Maximum value in the binary tree: " + maxValue);
    }
}
