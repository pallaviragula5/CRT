class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int data) {
        key = data;
        height = 1;  // Initial height of new node is 1
    }
}

class AVLTree {
    AVLNode root;

    // Get height of node
    int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    // Get balance factor of node
    int getBalanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Update height of node
    void updateHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Right rotate (LL Case)
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        updateHeight(y);
        updateHeight(x);

        // Return new root
        return x;
    }

    // Left rotate (RR Case)
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        updateHeight(x);
        updateHeight(y);

        // Return new root
        return y;
    }

    // Insert a node and balance the tree
    AVLNode insert(AVLNode node, int key) {
        // Step 1: Standard BST insert
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keys not allowed

        // Step 2: Update height of current node
        updateHeight(node);

        // Step 3: Get balance factor
        int balance = getBalanceFactor(node);

        // Step 4: Balance the tree

        // LL Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the unchanged node pointer
    }

    // Inorder traversal
    void inorderTraversal(AVLNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }
}

public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Driver code to insert values and balance the tree
        int[] values = { 10, 20, 30, 40, 50, 25 };

        for (int value : values) {
            tree.root = tree.insert(tree.root, value);
        }

        System.out.println("Inorder traversal of balanced AVL Tree:");
        tree.inorderTraversal(tree.root);
    }
}
