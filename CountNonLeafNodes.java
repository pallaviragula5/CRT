class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class CountNonLeafNodes {

    // Method to count non-leaf (internal) nodes
    int countNonLeafNodes(Node node) {
        if (node == null || (node.left == null && node.right == null))
            return 0;

        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
        */
        CountNonLeafNodes tree = new CountNonLeafNodes();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int nonLeafCount = tree.countNonLeafNodes(root);
        System.out.println("Number of non-leaf nodes: " + nonLeafCount);
    }
}
