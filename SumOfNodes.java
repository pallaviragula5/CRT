class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class SumOfNodes {

    // Method to calculate sum of all nodes
    int sumNodes(Node node) {
        if (node == null)
            return 0;
        return node.data + sumNodes(node.left) + sumNodes(node.right);
    }

    public static void main(String[] args) {
        /*
                 10
                /  \
               5    15
              / \     \
             3   7     20
        */
        SumOfNodes tree = new SumOfNodes();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(20);

        int totalSum = tree.sumNodes(root);
        System.out.println("Sum of all nodes: " + totalSum);
    }
}
