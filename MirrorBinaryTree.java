class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class MirrorBinaryTree {

    // Method to convert the tree to its mirror
    void mirror(Node node) {
        if (node == null)
            return;

        // Swap left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recur for left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    // Inorder traversal to print the tree
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
        */
        MirrorBinaryTree tree = new MirrorBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Inorder before mirroring:");
        tree.inorder(root);

        tree.mirror(root);

        System.out.println("\nInorder after mirroring:");
        tree.inorder(root);
    }
}
