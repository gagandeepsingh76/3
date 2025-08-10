import java.util.*;

/**
 * Tree Operations - Demonstrating both worst and best approaches
 * This file contains implementations of common tree operations and problems
 */

// TreeNode class for Binary Tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class TreeOperations {
    
    public static void main(String[] args) {
        TreeOperations treeOps = new TreeOperations();
        
        // Create a sample binary tree
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println("=== TREE TRAVERSALS ===");
        System.out.println("Inorder Traversal:");
        System.out.println("Worst: " + treeOps.inorderTraversalWorst(root));
        System.out.println("Best: " + treeOps.inorderTraversalBest(root));
        
        System.out.println("\nPreorder Traversal:");
        System.out.println("Worst: " + treeOps.preorderTraversalWorst(root));
        System.out.println("Best: " + treeOps.preorderTraversalBest(root));
        
        System.out.println("\nPostorder Traversal:");
        System.out.println("Worst: " + treeOps.postorderTraversalWorst(root));
        System.out.println("Best: " + treeOps.postorderTraversalBest(root));
        
        System.out.println("\nLevel Order Traversal:");
        System.out.println("Worst: " + treeOps.levelOrderTraversalWorst(root));
        System.out.println("Best: " + treeOps.levelOrderTraversalBest(root));
        
        System.out.println("\n=== TREE PROPERTIES ===");
        System.out.println("Maximum Depth:");
        System.out.println("Worst: " + treeOps.maxDepthWorst(root));
        System.out.println("Best: " + treeOps.maxDepthBest(root));
        
        System.out.println("\nSymmetric Tree Check:");
        TreeNode symmetricRoot = new TreeNode(1);
        symmetricRoot.left = new TreeNode(2);
        symmetricRoot.right = new TreeNode(2);
        symmetricRoot.left.left = new TreeNode(3);
        symmetricRoot.right.right = new TreeNode(3);
        
        System.out.println("Worst: " + treeOps.isSymmetricWorst(symmetricRoot));
        System.out.println("Best: " + treeOps.isSymmetricBest(symmetricRoot));
    }
    
    // ==================== TREE TRAVERSALS ====================
    
    /**
     * WORST APPROACH: Recursive inorder traversal
     * Time Complexity: O(n)
     * Space Complexity: O(h) - height of tree (worst case O(n))
     */
    public List<Integer> inorderTraversalWorst(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }
    
    private void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderRecursive(node.left, result);
        result.add(node.val);
        inorderRecursive(node.right, result);
    }
    
    /**
     * BEST APPROACH: Iterative inorder traversal using stack
     * Time Complexity: O(n)
     * Space Complexity: O(h) - but more controlled
     */
    public List<Integer> inorderTraversalBest(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        
        return result;
    }
    
    /**
     * WORST APPROACH: Recursive preorder traversal
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public List<Integer> preorderTraversalWorst(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }
    
    private void preorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorderRecursive(node.left, result);
        preorderRecursive(node.right, result);
    }
    
    /**
     * BEST APPROACH: Iterative preorder traversal using stack
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public List<Integer> preorderTraversalBest(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        
        return result;
    }
    
    /**
     * WORST APPROACH: Recursive postorder traversal
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public List<Integer> postorderTraversalWorst(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }
    
    private void postorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderRecursive(node.left, result);
        postorderRecursive(node.right, result);
        result.add(node.val);
    }
    
    /**
     * BEST APPROACH: Iterative postorder traversal using two stacks
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public List<Integer> postorderTraversalBest(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);
            
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        
        return result;
    }
    
    /**
     * WORST APPROACH: Recursive level order traversal
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> levelOrderTraversalWorst(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int height = getHeight(root);
        
        for (int i = 1; i <= height; i++) {
            List<Integer> level = new ArrayList<>();
            getLevelNodes(root, i, level);
            result.add(level);
        }
        
        return result;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    
    private void getLevelNodes(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;
        if (level == 1) {
            result.add(node.val);
        } else {
            getLevelNodes(node.left, level - 1, result);
            getLevelNodes(node.right, level - 1, result);
        }
    }
    
    /**
     * BEST APPROACH: Iterative level order traversal using queue
     * Time Complexity: O(n)
     * Space Complexity: O(w) - width of tree
     */
    public List<List<Integer>> levelOrderTraversalBest(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            
            result.add(level);
        }
        
        return result;
    }
    
    // ==================== TREE PROPERTIES ====================
    
    /**
     * WORST APPROACH: Using level order traversal to find depth
     * Time Complexity: O(n)
     * Space Complexity: O(w)
     */
    public int maxDepthWorst(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        
        return depth;
    }
    
    /**
     * BEST APPROACH: Simple recursive solution
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public int maxDepthBest(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthBest(root.left), maxDepthBest(root.right));
    }
    
    /**
     * WORST APPROACH: Convert to array and check symmetry
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isSymmetricWorst(TreeNode root) {
        if (root == null) return true;
        
        List<Integer> leftTraversal = new ArrayList<>();
        List<Integer> rightTraversal = new ArrayList<>();
        
        // Get left subtree traversal
        getLeftTraversal(root.left, leftTraversal);
        // Get right subtree traversal (mirrored)
        getRightTraversal(root.right, rightTraversal);
        
        return leftTraversal.equals(rightTraversal);
    }
    
    private void getLeftTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            result.add(null);
            return;
        }
        result.add(node.val);
        getLeftTraversal(node.left, result);
        getLeftTraversal(node.right, result);
    }
    
    private void getRightTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            result.add(null);
            return;
        }
        result.add(node.val);
        getRightTraversal(node.right, result);
        getRightTraversal(node.left, result);
    }
    
    /**
     * BEST APPROACH: Recursive comparison of left and right subtrees
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public boolean isSymmetricBest(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        
        return (left.val == right.val) &&
               isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
    
    // ==================== ADDITIONAL TREE OPERATIONS ====================
    
    /**
     * WORST APPROACH: Using inorder traversal to check BST
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isValidBSTWorst(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    private void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderTraversal(node.left, result);
        result.add(node.val);
        inorderTraversal(node.right, result);
    }
    
    /**
     * BEST APPROACH: Using range checking
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public boolean isValidBSTBest(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;
        
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        return isValidBSTHelper(node.left, min, node.val) &&
               isValidBSTHelper(node.right, node.val, max);
    }
    
    /**
     * WORST APPROACH: Using level order to find path
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public List<Integer> pathToNodeWorst(TreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        if (root == null) return path;
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parent.put(root, null);
        
        TreeNode targetNode = null;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            if (current.val == target) {
                targetNode = current;
                break;
            }
            
            if (current.left != null) {
                queue.offer(current.left);
                parent.put(current.left, current);
            }
            if (current.right != null) {
                queue.offer(current.right);
                parent.put(current.right, current);
            }
        }
        
        // Reconstruct path
        while (targetNode != null) {
            path.add(0, targetNode.val);
            targetNode = parent.get(targetNode);
        }
        
        return path;
    }
    
    /**
     * BEST APPROACH: Recursive path finding
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public List<Integer> pathToNodeBest(TreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        findPath(root, target, path);
        return path;
    }
    
    private boolean findPath(TreeNode node, int target, List<Integer> path) {
        if (node == null) return false;
        
        path.add(node.val);
        
        if (node.val == target) return true;
        
        if (findPath(node.left, target, path) || findPath(node.right, target, path)) {
            return true;
        }
        
        path.remove(path.size() - 1);
        return false;
    }
} 