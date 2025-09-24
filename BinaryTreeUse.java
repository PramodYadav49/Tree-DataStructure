package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
    //Take input in the Tree DataStructure
    public static TreeNode<Integer> TakeInput(Scanner s){
        int rootData;
        
        System.out.println("Enter the root Data");
        rootData=s.nextInt();
        if(rootData==-1){
            return null;
        }
        TreeNode<Integer> root=new TreeNode<Integer>(rootData);
        root.left=TakeInput(s);
        root.right=TakeInput(s);
        return root;

    }
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        
        System.out.println("Enter root data:");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null; // If root is -1, return null indicating an empty tree
        }

        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> front = pendingNodes.poll();

            System.out.println("Enter the left child of " + front.data + " (Enter -1 if no left child):");
            int leftChildData = s.nextInt();
            if (leftChildData != -1) {
                TreeNode<Integer> leftChild = new TreeNode<>(leftChildData);
                front.left = leftChild;
                pendingNodes.add(leftChild);
            }

            System.out.println("Enter the right child of " + front.data + " (Enter -1 if no right child):");
            int rightChildData = s.nextInt();
            if (rightChildData != -1) {
                TreeNode<Integer> rightChild = new TreeNode<>(rightChildData);
                front.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }

        return root;
    }


    //Problem
    public static int CountNode(TreeNode<Integer> root){
        if(root ==null){
            return 0;
        }
        int ans=1;
        ans+=CountNode(root.left);
        ans+=CountNode(root.right);

        return ans;


    }

    public static void printTree(TreeNode<Integer> root){
        if(root ==null){
            return;
        }
        String ToBePrinted=root.data+"";
        if(root.left!=null){
            ToBePrinted+="L:"+root.left.data;
        }
        if(root.right !=null){
            ToBePrinted+="R:"+root.right.data;

        }
        System.out.println(ToBePrinted);
        printTree(root.left);
        printTree((root.right));
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        TreeNode<Integer> root=takeInputLevelWise();
        printTree(root);
        // TreeNode<Integer> root=new TreeNode<Integer>(10);
        // TreeNode<Integer> node1=new TreeNode<Integer>(10);
        // TreeNode<Integer> node2=new TreeNode<Integer>(10);
        // TreeNode<Integer> node3=new TreeNode<Integer>(10);
        // root.left=node1;
        // root.right=node2;
        // node1.right=node3;


    }
}
