class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class CountLeafNodes {

    // Method to count leaf nodes
    int countLeafNodes(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
        */
        CountLeafNodes tree = new CountLeafNodes();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int leafCount = tree.countLeafNodes(root);
        System.out.println("Number of leaf nodes: " + leafCount);
    }
}
