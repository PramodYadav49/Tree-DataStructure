class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinarySearchTree {

   
    static Node insert(Node node, int val) {
        if (node == null)
            return new Node(val);

        if (val < node.val)
            node.left = insert(node.left, val);
        else if (val > node.val)
            node.right = insert(node.right, val);

        return node;
    }

   
    static void printBST(Node node) {
        if (node == null)
            return;
        
        printBST(node.left);
       
        printBST(node.right);
         System.out.print(node.val + " ->");
    }

    public static void main(String[] args) {
        Node root = null;

        int[] values = { 50, 30, 70, 20, 40, 60, 80 };
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("BST Preorder Traversal:");
        printBST(root);
    }
}
