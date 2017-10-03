package com.dsalgo;


import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    BinaryTree binaryTree;

    @Before
    public void createTree() {
        binaryTree = new BinaryTree();
        binaryTree.root = new BinaryTree.TreeNode(9);
        binaryTree.root.left = new BinaryTree.TreeNode(3);
        binaryTree.root.right = new BinaryTree.TreeNode(11);
        binaryTree.root.left.left = new BinaryTree.TreeNode(1);
        binaryTree.root.left.right = new BinaryTree.TreeNode(4);
        binaryTree.root.left.left.left = new BinaryTree.TreeNode(0);
        binaryTree.root.right.left = new BinaryTree.TreeNode(10);
        binaryTree.root.right.right = new BinaryTree.TreeNode(13);
        binaryTree.root.right.right.left = new BinaryTree.TreeNode(12);
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

    @Test
    public void searchBST() {
        System.out.println(binaryTree.searchBST(binaryTree.root, 12).val);
    }

    @Test
    public void binaryTreeSize() {
        System.out.println(binaryTree.binaryTreeSize(binaryTree.root));
    }

    @Test
    public void binaryTreeHeight() {
        System.out.println(binaryTree.binaryTreeHeight(binaryTree.root));
    }

    @Test
    public void rootToLeafSum() {
        System.out.println(binaryTree.rootToLeafSum(binaryTree.root, 16));
    }

    @Test
    public void isBST() {
        System.out.println(binaryTree.isBST(binaryTree.root));
    }

    @Test
    public void levelOrderTraversal() {
        binaryTree.levelOrderTraversal(binaryTree.root);
    }

    @Test
    public void iterativePostOrderTraversal() {
        binaryTree.iterativePostOrderTraversal(binaryTree.root);
    }

    @Test
    public void iterativePreOrderTraversal() {
        binaryTree.iterativePreOrderTraversal(binaryTree.root);
    }

    @Test
    public void iterativeInOrderTraversal() {
        binaryTree.iterativeInOrderTraversal(binaryTree.root);
    }
}