/*
 * Software property of Acquisio. Copyright 2003-2017.
 */
package model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author dzhang
 */
public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){

    }

    o
    /**
     * Build Up the Tree
     */
    public static void buildUpBinaryTree(TreeNode root, int depth) {
        if (depth == 0) {
            return;
        }
        if (root == null) {
            root = new TreeNode();
            root.value = new Random().nextInt(100);
        }
        TreeNode left = new TreeNode();
        left.value = new Random().nextInt(100);
        TreeNode right = new TreeNode();
        right.value = new Random().nextInt(100);
        root.left = left;
        root.right = right;
        buildUpBinaryTree(root.left, depth - 1);
        buildUpBinaryTree(root.right, depth - 1);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.println(current);
            if (current.left != null) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode.buildUpBinaryTree(root, 2);
        root.printTree(root);
    }
}