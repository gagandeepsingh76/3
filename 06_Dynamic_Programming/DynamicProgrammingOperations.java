import java.util.*;

/**
 * Dynamic Programming Operations - Demonstrating both worst and best approaches
 * This file contains implementations of common dynamic programming problems
 */
public class DynamicProgrammingOperations {
    
    public static void main(String[] args) {
        DynamicProgrammingOperations dpOps = new DynamicProgrammingOperations();
        
        // Test Fibonacci
        System.out.println("=== FIBONACCI ===");
        System.out.println("Fibonacci(10) (Worst): " + dpOps.fibonacciWorst(10));
        System.out.println("Fibonacci(10) (Best): " + dpOps.fibonacciBest(10));
        
        // Test Climbing Stairs
        System.out.println("\n=== CLIMBING STAIRS ===");
        System.out.println("Ways to climb 5 stairs (Worst): " + dpOps.climbStairsWorst(5));
        System.out.println("Ways to climb 5 stairs (Best): " + dpOps.climbStairsBest(5));
        
        // Test Coin Change
        System.out.println("\n=== COIN CHANGE ===");
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Min coins for " + amount + " (Worst): " + dpOps.coinChangeWorst(coins, amount));
        System.out.println("Min coins for " + amount + " (Best): " + dpOps.coinChangeBest(coins, amount));
        
        // Test Longest Common Subsequence
        System.out.println("\n=== LONGEST COMMON SUBSEQUENCE ===");
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("LCS length (Worst): " + dpOps.longestCommonSubsequenceWorst(text1, text2));
        System.out.println("LCS length (Best): " + dpOps.longestCommonSubsequenceBest(text1, text2));
        
        // Test Longest Increasing Subsequence
        System.out.println("\n=== LONGEST INCREASING SUBSEQUENCE ===");
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS length (Worst): " + dpOps.lengthOfLISWorst(nums));
        System.out.println("LIS length (Best): " + dpOps.lengthOfLISBest(nums));
        
        // Test 0/1 Knapsack
        System.out.println("\n=== 0/1 KNAPSACK ===");
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;
        System.out.println("Max value (Worst): " + dpOps.knapsackWorst(weights, values, capacity));
        System.out.println("Max value (Best): " + dpOps.knapsackBest(weights, values, capacity));
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
     * BEST APPROACH: Bottom-up DP with space optimization
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int fibonacciBest(int n) {
        if (n <= 1) return n;
        
        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
    
    // ==================== CLIMBING STAIRS ====================
    
    /**
     * WORST APPROACH: Simple recursive approach
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) - call stack
     */
    public int climbStairsWorst(int n) {
        if (n <= 2) return n;
        return climbStairsWorst(n - 1) + climbStairsWorst(n - 2);
    }
    
    /**
     * BEST APPROACH: Bottom-up DP with space optimization
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int climbStairsBest(int n) {
        if (n <= 2) return n;
        
        int prev = 1, curr = 2;
        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
    
    // ==================== COIN CHANGE ====================
    
    /**
     * WORST APPROACH: Recursive with memoization
     * Time Complexity: O(amount * coins.length)
     * Space Complexity: O(amount)
     */
    public int coinChangeWorst(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        return coinChangeHelper(coins, amount, memo);
    }
    
    private int coinChangeHelper(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        
        if (memo[amount] != -1) return memo[amount];
        
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChangeHelper(coins, amount - coin, memo);
            if (result != -1) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
        
        memo[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[amount];
    }
    
    /**
     * BEST APPROACH: Bottom-up DP
     * Time Complexity: O(amount * coins.length)
     * Space Complexity: O(amount)
     */
    public int coinChangeBest(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    // ==================== LONGEST COMMON SUBSEQUENCE ====================
    
    /**
     * WORST APPROACH: Recursive with memoization
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public int longestCommonSubsequenceWorst(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return lcsHelper(text1, text2, m - 1, n - 1, memo);
    }
    
    private int lcsHelper(String text1, String text2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) return 0;
        
        if (memo[i][j] != -1) return memo[i][j];
        
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + lcsHelper(text1, text2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(lcsHelper(text1, text2, i - 1, j, memo),
                                 lcsHelper(text1, text2, i, j - 1, memo));
        }
        
        return memo[i][j];
    }
    
    /**
     * BEST APPROACH: Bottom-up DP with space optimization
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m, n))
     */
    public int longestCommonSubsequenceBest(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        
        // Use the shorter string for the DP array
        if (m < n) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
            int tempLen = m;
            m = n;
            n = tempLen;
        }
        
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        
        return dp[n];
    }
    
    // ==================== LONGEST INCREASING SUBSEQUENCE ====================
    
    /**
     * WORST APPROACH: Recursive with memoization
     * Time Complexity: O(n²)
     * Space Complexity: O(n²)
     */
    public int lengthOfLISWorst(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return lisHelper(nums, 0, -1, memo);
    }
    
    private int lisHelper(int[] nums, int index, int prevIndex, int[][] memo) {
        if (index == nums.length) return 0;
        
        if (memo[index][prevIndex + 1] != -1) {
            return memo[index][prevIndex + 1];
        }
        
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + lisHelper(nums, index + 1, index, memo);
        }
        
        int notTake = lisHelper(nums, index + 1, prevIndex, memo);
        
        memo[index][prevIndex + 1] = Math.max(take, notTake);
        return memo[index][prevIndex + 1];
    }
    
    /**
     * BEST APPROACH: Binary search approach
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int lengthOfLISBest(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        
        return sub.size();
    }
    
    private int binarySearch(List<Integer> sub, int num) {
        int left = 0, right = sub.size() - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // ==================== 0/1 KNAPSACK ====================
    
    /**
     * WORST APPROACH: Recursive with memoization
     * Time Complexity: O(n * capacity)
     * Space Complexity: O(n * capacity)
     */
    public int knapsackWorst(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] memo = new int[n][capacity + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return knapsackHelper(weights, values, capacity, n - 1, memo);
    }
    
    private int knapsackHelper(int[] weights, int[] values, int capacity, int index, int[][] memo) {
        if (index < 0 || capacity == 0) return 0;
        
        if (memo[index][capacity] != -1) {
            return memo[index][capacity];
        }
        
        int notTake = knapsackHelper(weights, values, capacity, index - 1, memo);
        int take = 0;
        
        if (weights[index] <= capacity) {
            take = values[index] + knapsackHelper(weights, values, capacity - weights[index], index - 1, memo);
        }
        
        memo[index][capacity] = Math.max(take, notTake);
        return memo[index][capacity];
    }
    
    /**
     * BEST APPROACH: Bottom-up DP with space optimization
     * Time Complexity: O(n * capacity)
     * Space Complexity: O(capacity)
     */
    public int knapsackBest(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        
        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
        
        return dp[capacity];
    }
    
    // ==================== ADDITIONAL DP PROBLEMS ====================
    
    /**
     * WORST APPROACH: Recursive edit distance
     * Time Complexity: O(3^(m+n))
     * Space Complexity: O(m + n)
     */
    public int editDistanceWorst(String word1, String word2) {
        return editDistanceHelper(word1, word2, word1.length(), word2.length());
    }
    
    private int editDistanceHelper(String word1, String word2, int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;
        
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return editDistanceHelper(word1, word2, i - 1, j - 1);
        }
        
        return 1 + Math.min(
            editDistanceHelper(word1, word2, i - 1, j),     // Delete
            Math.min(
                editDistanceHelper(word1, word2, i, j - 1), // Insert
                editDistanceHelper(word1, word2, i - 1, j - 1) // Replace
            )
        );
    }
    
    /**
     * BEST APPROACH: Bottom-up DP
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public int editDistanceBest(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
    
    /**
     * WORST APPROACH: Recursive matrix chain multiplication
     * Time Complexity: O(4^n)
     * Space Complexity: O(n)
     */
    public int matrixChainMultiplicationWorst(int[] dimensions) {
        return mcmHelper(dimensions, 1, dimensions.length - 1);
    }
    
    private int mcmHelper(int[] dimensions, int i, int j) {
        if (i == j) return 0;
        
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = dimensions[i - 1] * dimensions[k] * dimensions[j] +
                      mcmHelper(dimensions, i, k) +
                      mcmHelper(dimensions, k + 1, j);
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }
    
    /**
     * BEST APPROACH: Bottom-up DP
     * Time Complexity: O(n³)
     * Space Complexity: O(n²)
     */
    public int matrixChainMultiplicationBest(int[] dimensions) {
        int n = dimensions.length - 1;
        int[][] dp = new int[n][n];
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    int cost = dimensions[i] * dimensions[k + 1] * dimensions[j + 1] +
                              dp[i][k] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[0][n - 1];
    }
} 