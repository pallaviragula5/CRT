class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class CountNodesBinaryTree {

    // Method to count total nodes in the tree
    int countNodes(Node node) {
        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
        CountNodesBinaryTree tree = new CountNodesBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Count nodes
        int totalNodes = tree.countNodes(root);
        System.out.println("Total number of nodes in the binary tree: " + totalNodes);
    }
}
