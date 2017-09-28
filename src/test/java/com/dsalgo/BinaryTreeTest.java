package com.dsalgo;


import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    BinaryTree binaryTree;

    @Before
    public void createTree() {
        binaryTree = new BinaryTree();
        binaryTree.root = new BinaryTree.TreeNode(5);
        binaryTree.root.left = new BinaryTree.TreeNode(2);
        binaryTree.root.right = new BinaryTree.TreeNode(12);
        binaryTree.root.left.left = new BinaryTree.TreeNode(3);
        binaryTree.root.left.right = new BinaryTree.TreeNode(8);
        binaryTree.root.left.left.left = new BinaryTree.TreeNode(1);
        binaryTree.root.right.left = new BinaryTree.TreeNode(11);
        binaryTree.root.right.right = new BinaryTree.TreeNode(10);
        binaryTree.root.right.left.left = new BinaryTree.TreeNode(15);
    }

    @Test
    public void preorderTraversal() throws Exception {
        System.out.print("preorderTraversal: ");
        binaryTree.preorderTraversal(binaryTree.root);
        System.out.println();
    }

    @Test
    public void inorderTraversal() throws Exception {
        System.out.print("inorderTraversal: ");
        binaryTree.inorderTraversal(binaryTree.root);
        System.out.println();
    }

    @Test
    public void postorderTraversal() throws Exception {
        System.out.print("postorderTraversal: ");
        binaryTree.postorderTraversal(binaryTree.root);
        System.out.println();
    }

}