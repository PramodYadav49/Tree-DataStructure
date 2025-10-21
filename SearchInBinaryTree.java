public class SearchInBinaryTree {
    static boolean search(Node node ,int val){
        if(node == null) return false;
        else if(node.val == val) return true;
        else if(node.val < val) return  search(node.right, val);
        else  return search(node.left, val);
       
    }
    static Node insert(Node node, int val) {
        if (node == null)
            return new Node(val);

        if (val < node.val)
            node.left = insert(node.left, val);
        else if (val > node.val)
            node.right = insert(node.right, val);

        return node;
    }
    public static void main(String[] args) {
        Node root = null;

        int[] values = { 50, 30, 70, 20, 40, 60, 80 };
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println(search(root, 30));
      
    }
}
