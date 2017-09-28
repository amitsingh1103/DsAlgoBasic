package com.dsalgo;

import java.util.Objects;

public class BinaryTree {

    TreeNode root;

    /**
     * Binary Tree Traversal:
     *  1. Depth First Binary Tree Traversal
     *      i. Preorder traversal
     *      ii. inorder traversal
     *      iii. postorder traversal
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Preorder traversal: V->L->R
     */
    public void preorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        System.out.print(root.val +",");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /**
     * inorder traversal: L->V->R
     */
    public void inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + ",");
        inorderTraversal(root.right);
    }

    /**
     * Postorder traversal: L->R->V
     */
    public void postorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + ",");
    }
}
