package com.dsalgo;

import java.util.*;

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
        TreeNode parent;

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

    /**
     * Search in Binary Search tree
     */
    public TreeNode searchBST(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return root;
        }

        if (root.val == key) {
            return root;
        }

        if (root.val < key) {
            return searchBST(root.right, key);
        }

        return searchBST(root.left, key);
    }

    /**
     * Insert in Binary Search Tree(Iterative Method)
     */
    public TreeNode insertBST(TreeNode root, int key) {
        TreeNode node = new TreeNode(key);
        if (Objects.isNull(root)) {
            return node;
        }

        TreeNode current = root;
        TreeNode parent = null;
        while (Objects.isNull(current)) {
            if (current.val == key) {
                return root;
            }

            parent = current;
            if (current.val < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (parent.val < key) {
            parent.right = node;
        } else {
            parent.left = node;
        }

        return root;
    }

    /**
     * Same binary tree
     */
    public boolean sameBinaryTree(TreeNode _1root, TreeNode _2root) {
        if (Objects.isNull(_1root) && Objects.isNull(_2root)) {
            return true;
        }

        if (Objects.isNull(_1root) || Objects.isNull(_2root)) {
            return false;
        }

        return _1root.val == _2root.val
                && sameBinaryTree(_1root.left, _2root.left)
                && sameBinaryTree(_1root.right, _2root.right);
    }

    /**
     * Size of Binary Tree -> Number of nodes in BT
     */
    public int binaryTreeSize(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        return binaryTreeSize(root.left)
                + binaryTreeSize(root.right)
                + 1;
    }

    /**
     * Height of binary tree
     */
    public int binaryTreeHeight(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        return 1 + Math.max(binaryTreeHeight(root.left), binaryTreeHeight(root.right));
    }

    /**
     * Root to leaf sum of binary tree
     */
    public boolean rootToLeafSum(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return false;
        }

        if (Objects.isNull(root.left) && Objects.isNull(root.right) && root.val == sum) {
            return true;
        }

        sum -= root.val;
        return rootToLeafSum(root.left, sum) || rootToLeafSum(root.right,sum);
    }

    /**
     * Check if binary tree is BST
     */
    public boolean isBST(TreeNode root) {
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;

        return _isBST(root, min, max);
    }

    private boolean _isBST(TreeNode root, Integer min, Integer max) {
        if (Objects.isNull(root)) {
            return true;
        }

        return (root.val > min && root.val < max)
                && _isBST(root.left, min, root.val)
                && _isBST(root.right, root.val, max);
    }

    /**
     * Level Order Traversal of Binary Tree
     */
    public void levelOrderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + ", ");
            if (Objects.nonNull(node.left)) {
                queue.add(node.left);
            }

            if (Objects.nonNull(node.right)) {
                queue.add(node.right);
            }
            level++;
        }
    }

    /**
     * Iterative PostOrder Traversal of binary tree using single stack
     */
    public void iterativePostOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (Objects.nonNull(current) || !stack.empty()) {
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (Objects.isNull(temp)) {
                    temp = stack.pop();
                    System.out.print(temp.val + ", ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.val + ", ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    /**
     * Iterative Preorder Traversal of Binary Tree using single stack
     */
    public void iterativePreOrderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + ", ");

            if (Objects.nonNull(node.right)) {
                stack.push(node.right);
            }
            if (Objects.nonNull(node.left)) {
                stack.push(node.left);
            }
        }
    }

    /**
     * Iterative Inorder Traversal of Binary tree using single stack
     */
    public void iterativeInOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                current = stack.pop();
                System.out.print(current.val + ", ");
                current = current.right;
            }
        }
    }

    /**
     * BST is a binary tree with BST property: Let x be a node in a binary search tree property. If y is a node in
     * left subtree of x then y.key <= x.key. If y is a node in the right subtree then y.key >= x.key.
     * This data structure supports all dynamic set operations like INSERT, DELETE, SEARCH, MINIMUM, MAXIMUM,
     * PREDECESSOR, SUCCESSOR.
     * Binary Search Tree Minimum
     */
    public TreeNode treeMinimum(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Binary Search Tree Successor
     */
    public TreeNode treeSuccessor(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode current = root;
        // case 1: Have right subtree-> Get the minimum(leftmost) node in the right subtree of the node.
        if (current.right != null) {
            return treeMinimum(current);
        }

        // case 2: Do not have right subtree-> Go up the tree till we encounter a node in whose left subtree this
        // node is falling.
        TreeNode parent = current.parent;
        while (parent != null && current == parent.right) {
            current = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * Binary Search Tree Deletion
     * Algorithm:-
     * 1. If z has no left child, then we replace z by its right child, which may or may not be NIL.
     *      a. When z’s right child is NIL, this case deals with the situation in which z has no children.
     *      b. When z's right child is non-NIL, this case handles the situation in which z has just one child, which
     *      is its right child.
     * 2. If z has just one child, which is its left child, then we replace z by its left child.
     * 3. Otherwise, z has both a left and a right child. We find z’s successor y, which lies in z’s right subtree and
     * has no left child. We want to splice y out of its current location and have it replace z in the tree.
     *      a. If y is z’s right child, then we replace z by y, leaving y’s right child alone.
     *      b. Otherwise, y lies within z's right subtree but is not z’s right child. In this case, we first replace
     *      y by its own right child, and then we replace z by y.
     */
    public TreeNode bstDeletion(TreeNode root, TreeNode z) {
        if (root == null || z == null) {
            return root;
        }

        // Case 1: Left child is null
        if (z.left == null) {
            bstSubtreeTransplant(root, z, z.right);
            return root;
        } else if (z.right == null) {
            // Case 2: right child is null
            bstSubtreeTransplant(root, z, z.left);
            return root;
        }
        // Case 3: Both left and right child are not null
        TreeNode successorNode = treeMinimum(z.right);
        if (successorNode != z.right) {
            // Case 3.b
            bstSubtreeTransplant(root, successorNode, successorNode.right);
            successorNode.right = z.right;
            successorNode.right.parent = successorNode;
        }
        // Common to both case 3.a and case 3.b:
        bstSubtreeTransplant(root, z, successorNode);
        successorNode.left = z.left;
        successorNode.left.parent = successorNode;
        return root;
    }

    private void bstSubtreeTransplant(TreeNode root, TreeNode source, TreeNode target) {
        if (source.parent == null) {
            root = target;
        } else if (source == source.parent.left) {
            source.parent.left = target;
        } else {
            source.parent.right = target;
        }

        if (target != null) {
            target.parent = source.parent;
        }
    }

    /**
     * Level by level printing of binary tree
     *
     * Solution: Using a queue and print next line when current level completes.
     */
    public void printBTLevelByLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int current = 1;
        int next = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + ", ");
            if (node.left != null) {
                q.add(node.left);
                next++;
            }
            if (node.right != null) {
                q.add(node.right);
                next++;
            }

            current--;
            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }
        }
    }

    /**
     * Reverse level order traversal of binary tree
     *
     * Solution: Use queue and store each list of levels in a stack.
     */
    public void printLevelOrderTraversalInReverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<List<TreeNode>> s = new Stack<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int current = 1;
        int next = 0;
        List<TreeNode> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.add(node.left);
                next++;
            }
            if (node.right != null) {
                q.add(node.right);
                next++;
            }

            current--;
            level.add(node);
            if (current == 0) {
                s.add(level);
                current = next;
                next = 0;
                level = new ArrayList<>();
            }
        }

        while (!s.isEmpty()) {
            s.pop().stream().forEach(node -> System.out.print(node.val + ", "));
        }
    }

    /**
     * Tree traversal spiral order
     *
     * Solution: 2 stacks or deque technique: O(n)
     */
    public void printBtSpiralOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerFirst(root);
        int firstCount = 1;
        int lastCount = 0;
        TreeNode node;
        while (firstCount !=0 || lastCount != 0) {
            while (firstCount != 0) {
                node = dq.pollFirst();
                System.out.print(node.val + ", ");
                if (node.left != null) {
                    dq.offerLast(node.left);
                    lastCount++;
                }
                if (node.right != null) {
                    dq.offerLast(node.right);
                    lastCount++;
                }
                firstCount--;
            }
            System.out.println();
            while (lastCount != 0) {
                node = dq.pollLast();
                System.out.print(node.val + ", ");
                if (node.right != null) {
                    dq.offerFirst(node.right);
                    firstCount++;
                }
                if (node.left != null) {
                    dq.offerFirst(node.left);
                    firstCount++;
                }
                lastCount--;
            }
            System.out.println();
        }
    }

    /**
     * Lowest Common Ancestor of BST.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**
     * Lowest Common Ancestor of binary tree.
     */
    public TreeNode lcaOfBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lcaOfBinaryTree(root.left, p, q);
        TreeNode right = lcaOfBinaryTree(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        }
        return left != null ? left : right;
    }

    /**
     * Largest BST in Binary Tree.
     */
    public int largestBST(TreeNode root) {
        MinMax minMax = largest(root);
        return minMax.size;
    }

    private MinMax largest(TreeNode root) {
        if (root == null) {
            return new MinMax();
        }

        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax = largest(root.right);

        if (!leftMinMax.isBST || !rightMinMax.isBST || (leftMinMax.max > root.val) || (rightMinMax.min < root.val)) {
            return new MinMax(false, 0, 0, Math.max(leftMinMax.size, rightMinMax.size));
        }

        MinMax minMax = new MinMax();
        minMax.isBST = true;
        minMax.size = leftMinMax.size + rightMinMax.size + 1;
        minMax.min = leftMinMax != null ? leftMinMax.min : root.val;
        minMax.max = rightMinMax != null ? rightMinMax.max : root.val;
        return minMax;
    }

    private class MinMax {
        private boolean isBST;
        private int min;
        private int max;
        private int size;

        public MinMax() {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            isBST = true;
            size = 0;
        }

        public MinMax(boolean isBST, int min, int max, int size) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    /**
     * Morris Inorder Traversal of Binary Tree
     */

}
