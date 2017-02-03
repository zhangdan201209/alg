/*
 * Software property of Acquisio. Copyright 2003-2017.
 */

import java.util.Random;
import model.TreeNode;

/**
 * @author dzhang
 */
public class BinarySearchTree {

    /**
     * Brute Force O(n2)
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSubTreeLargerThan(root.right, root.value) && isSubtreeLessThan(root.left, root.value) && isValidBST(root.left) &&
                isValidBST(root.right);
    }

    private static boolean isSubtreeLessThan(TreeNode p, int val) {
        if (p == null) {
            return true;
        }
        return p.value < val && isSubtreeLessThan(p.left, val) && isSubtreeLessThan(p.right, val);
    }

    private static boolean isSubTreeLargerThan(TreeNode p, int val) {
        if (p == null) {
            return true;
        }
        return p.value > val && isSubTreeLargerThan(p.left, val) && isSubTreeLargerThan(p.right, val);
    }

    /**
     * Top down recursive O(n)
     * @param args
     */

    public static boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return root.value<max && root.value>min && isValidBST(root.left,min,root.value) && isValidBST(root.right,root.value,max);
    }

    public static int maxDepth(TreeNode root){
        if(root ==null){
            return 0;
        }
        return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.value = 50;
        TreeNode.buildUpBinaryTree(root, 1);
        root.printTree(root);
        System.out.println(BinarySearchTree.maxDepth(root));
        System.out.println(BinarySearchTree.isValidBST(root));
        System.out.println(BinarySearchTree.isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}