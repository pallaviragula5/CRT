class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTreeSearch {

    // Method to search for a value in the tree
    Node search(Node node, int value) {
        if (node == null)
            return null;
        if (node.data == value)
            return node;

        // Search in left subtree
        Node leftResult = search(node.left, value);
        if (leftResult != null)
            return leftResult;

        // Search in right subtree
        return search(node.right, value);
    }

    public static void main(String[] args) {
        /*
                 10
                /  \
               5    20
              / \   /
             3   7 15
        */
        BinaryTreeSearch tree = new BinaryTreeSearch();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(15);

        int searchValue = 7;
        Node result = tree.search(root, searchValue);

        if (result != null)
            System.out.println("Value " + searchValue + " found in node with data: " + result.data);
        else
            System.out.println("Value " + searchValue + " not found in the tree.");
    }
}
