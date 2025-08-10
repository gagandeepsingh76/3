import java.util.*;

/**
 * Recursion and Backtracking Operations - Demonstrating both worst and best approaches
 * This file contains implementations of common recursion and backtracking problems
 */
public class RecursionOperations {
    
    public static void main(String[] args) {
        RecursionOperations recOps = new RecursionOperations();
        
        // Test factorial
        System.out.println("=== FACTORIAL ===");
        System.out.println("Factorial of 5 (Worst): " + recOps.factorialWorst(5));
        System.out.println("Factorial of 5 (Best): " + recOps.factorialBest(5));
        
        // Test Fibonacci
        System.out.println("\n=== FIBONACCI ===");
        System.out.println("Fibonacci(10) (Worst): " + recOps.fibonacciWorst(10));
        System.out.println("Fibonacci(10) (Best): " + recOps.fibonacciBest(10));
        
        // Test power
        System.out.println("\n=== POWER ===");
        System.out.println("2^10 (Worst): " + recOps.powerWorst(2, 10));
        System.out.println("2^10 (Best): " + recOps.powerBest(2, 10));
        
        // Test GCD
        System.out.println("\n=== GCD ===");
        System.out.println("GCD(48, 18) (Worst): " + recOps.gcdWorst(48, 18));
        System.out.println("GCD(48, 18) (Best): " + recOps.gcdBest(48, 18));
        
        // Test permutations
        System.out.println("\n=== PERMUTATIONS ===");
        int[] nums = {1, 2, 3};
        System.out.println("Permutations (Worst): " + recOps.permutationsWorst(nums));
        System.out.println("Permutations (Best): " + recOps.permutationsBest(nums));
        
        // Test subsets
        System.out.println("\n=== SUBSETS ===");
        System.out.println("Subsets (Worst): " + recOps.subsetsWorst(nums));
        System.out.println("Subsets (Best): " + recOps.subsetsBest(nums));
        
        // Test N-Queens
        System.out.println("\n=== N-QUEENS ===");
        System.out.println("4-Queens solutions (Worst): " + recOps.solveNQueensWorst(4).size());
        System.out.println("4-Queens solutions (Best): " + recOps.solveNQueensBest(4).size());
    }
    
    // ==================== FACTORIAL ====================
    
    /**
     * WORST APPROACH: Simple recursive factorial
     * Time Complexity: O(n)
     * Space Complexity: O(n) - call stack
     */
    public long factorialWorst(int n) {
        if (n <= 1) return 1;
        return n * factorialWorst(n - 1);
    }
    
    /**
     * BEST APPROACH: Iterative factorial
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public long factorialBest(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    // ==================== FIBONACCI ====================
    
    /**
     * WORST APPROACH: Simple recursive Fibonacci
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) - call stack
     */
    public int fibonacciWorst(int n) {
        if (n <= 1) return n;
        return fibonacciWorst(n - 1) + fibonacciWorst(n - 2);
    }
    
    /**
     * BEST APPROACH: Dynamic programming with memoization
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int fibonacciBest(int n) {
        if (n <= 1) return n;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    // ==================== POWER ====================
    
    /**
     * WORST APPROACH: Simple recursive power
     * Time Complexity: O(n)
     * Space Complexity: O(n) - call stack
     */
    public double powerWorst(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / powerWorst(x, -n);
        return x * powerWorst(x, n - 1);
    }
    
    /**
     * BEST APPROACH: Fast power (divide and conquer)
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) - call stack
     */
    public double powerBest(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        if (n % 2 == 0) {
            double half = powerBest(x, n / 2);
            return half * half;
        } else {
            return x * powerBest(x, n - 1);
        }
    }
    
    // ==================== GCD ====================
    
    /**
     * WORST APPROACH: Iterative GCD
     * Time Complexity: O(min(a, b))
     * Space Complexity: O(1)
     */
    public int gcdWorst(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
    
    /**
     * BEST APPROACH: Euclidean algorithm
     * Time Complexity: O(log(min(a, b)))
     * Space Complexity: O(1)
     */
    public int gcdBest(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // ==================== PERMUTATIONS ====================
    
    /**
     * WORST APPROACH: Generate all permutations using extra space
     * Time Complexity: O(n!)
     * Space Complexity: O(n!)
     */
    public List<List<Integer>> permutationsWorst(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        
        // Convert to list for easier manipulation
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        
        generatePermutationsWorst(numList, new ArrayList<>(), result);
        return result;
    }
    
    private void generatePermutationsWorst(List<Integer> nums, List<Integer> current, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            current.add(num);
            nums.remove(i);
            
            generatePermutationsWorst(nums, current, result);
            
            nums.add(i, num);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * BEST APPROACH: Generate permutations in-place using backtracking
     * Time Complexity: O(n!)
     * Space Complexity: O(n) - call stack
     */
    public List<List<Integer>> permutationsBest(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsBest(nums, 0, result);
        return result;
    }
    
    private void generatePermutationsBest(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            // Swap elements
            swap(nums, start, i);
            generatePermutationsBest(nums, start + 1, result);
            // Backtrack
            swap(nums, start, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // ==================== SUBSETS ====================
    
    /**
     * WORST APPROACH: Generate all subsets using bit manipulation
     * Time Complexity: O(n * 2^n)
     * Space Complexity: O(2^n)
     */
    public List<List<Integer>> subsetsWorst(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n
        
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        
        return result;
    }
    
    /**
     * BEST APPROACH: Generate subsets using backtracking
     * Time Complexity: O(n * 2^n)
     * Space Complexity: O(n) - call stack
     */
    public List<List<Integer>> subsetsBest(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void generateSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    // ==================== N-QUEENS ====================
    
    /**
     * WORST APPROACH: Check all possible positions
     * Time Complexity: O(n^n)
     * Space Complexity: O(n²)
     */
    public List<List<String>> solveNQueensWorst(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        solveNQueensWorstHelper(board, 0, result);
        return result;
    }
    
    private void solveNQueensWorstHelper(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(constructSolution(board));
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (isValidWorst(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensWorstHelper(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isValidWorst(char[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // Check diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    /**
     * BEST APPROACH: Optimized N-Queens with better validation
     * Time Complexity: O(n!)
     * Space Complexity: O(n)
     */
    public List<List<String>> solveNQueensBest(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // queens[i] = column position of queen in row i
        Arrays.fill(queens, -1);
        
        solveNQueensBestHelper(queens, 0, result);
        return result;
    }
    
    private void solveNQueensBestHelper(int[] queens, int row, List<List<String>> result) {
        if (row == queens.length) {
            result.add(constructSolutionFromQueens(queens));
            return;
        }
        
        for (int col = 0; col < queens.length; col++) {
            if (isValidBest(queens, row, col)) {
                queens[row] = col;
                solveNQueensBestHelper(queens, row + 1, result);
                queens[row] = -1;
            }
        }
    }
    
    private boolean isValidBest(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> constructSolutionFromQueens(int[] queens) {
        List<String> solution = new ArrayList<>();
        int n = queens.length;
        
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(queens[i] == j ? 'Q' : '.');
            }
            solution.add(row.toString());
        }
        
        return solution;
    }
    
    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
    
    // ==================== ADDITIONAL RECURSION PROBLEMS ====================
    
    /**
     * WORST APPROACH: Simple recursive sum
     * Time Complexity: O(n)
     * Space Complexity: O(n) - call stack
     */
    public int sumWorst(int n) {
        if (n <= 1) return n;
        return n + sumWorst(n - 1);
    }
    
    /**
     * BEST APPROACH: Formula-based sum
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int sumBest(int n) {
        return n * (n + 1) / 2;
    }
    
    /**
     * WORST APPROACH: Recursive palindrome check
     * Time Complexity: O(n)
     * Space Complexity: O(n) - call stack
     */
    public boolean isPalindromeWorst(String str) {
        if (str.length() <= 1) return true;
        if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
        return isPalindromeWorst(str.substring(1, str.length() - 1));
    }
    
    /**
     * BEST APPROACH: Two-pointer palindrome check
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPalindromeBest(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
} 