package com.dsalgo;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

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

    @Test
    public void printBtSpiralOrder() {
        binaryTree.printBtSpiralOrder(binaryTree.root);
    }

    @Test
    public void lowestCommonAncestor() {
        System.out.println(binaryTree.lowestCommonAncestor(binaryTree.root, binaryTree.root.left.left, binaryTree
                .root.left.right).val);
    }

    @Test
    public void lcaOfBinaryTree() {
        System.out.println(binaryTree.lcaOfBinaryTree(binaryTree.root, binaryTree.root.left.left, binaryTree
                .root.left.right).val);
    }

    @Test
    public void largestBST() {
        List<String> list = new ArrayList<>();
        IntStream.range(1, 2000000).forEach(a -> list.add(String.valueOf(a)));
        Pattern pattern = Pattern.compile("12");
        Matcher matcher = pattern.matcher("");
        long t1 = System.currentTimeMillis();
        list.stream().forEach(a -> {
            //a.matches("amitsin%$@#@$@IGWKsbejkbejknlemgh_singhasdvksvd%$$$^5kn6k54nk'n3t4qwmi");
            /*matcher.reset(a);
            if (matcher.matches()) {
                System.out.println(a);
            }*/
        });
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(binaryTree.largestBST(binaryTree.root));
    }
}