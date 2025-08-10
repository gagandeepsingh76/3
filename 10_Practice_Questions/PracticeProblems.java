import java.util.*;

/**
 * Practice Problems - Collection of common DSA problems with both worst and best approaches
 * This file contains implementations of popular coding interview problems
 */
public class PracticeProblems {
    
    public static void main(String[] args) {
        PracticeProblems practice = new PracticeProblems();
        
        // Test Two Sum
        System.out.println("=== TWO SUM ===");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Two Sum (Worst): " + Arrays.toString(practice.twoSumWorst(nums, target)));
        System.out.println("Two Sum (Best): " + Arrays.toString(practice.twoSumBest(nums, target)));
        
        // Test Maximum Subarray
        System.out.println("\n=== MAXIMUM SUBARRAY ===");
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Subarray Sum (Worst): " + practice.maxSubArrayWorst(arr));
        System.out.println("Max Subarray Sum (Best): " + practice.maxSubArrayBest(arr));
        
        // Test Valid Parentheses
        System.out.println("\n=== VALID PARENTHESES ===");
        String[] parentheses = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String s : parentheses) {
            System.out.println(s + " (Worst): " + practice.isValidParenthesesWorst(s));
            System.out.println(s + " (Best): " + practice.isValidParenthesesBest(s));
        }
        
        // Test Merge Two Sorted Lists
        System.out.println("\n=== MERGE TWO SORTED LISTS ===");
        ListNode l1 = practice.createList(new int[]{1, 3, 5});
        ListNode l2 = practice.createList(new int[]{2, 4, 6});
        System.out.println("Merged List (Worst): " + practice.listToString(practice.mergeTwoListsWorst(l1, l2)));
        ListNode l3 = practice.createList(new int[]{1, 3, 5});
        ListNode l4 = practice.createList(new int[]{2, 4, 6});
        System.out.println("Merged List (Best): " + practice.listToString(practice.mergeTwoListsBest(l3, l4)));
        
        // Test Reverse String
        System.out.println("\n=== REVERSE STRING ===");
        String testStr = "Hello World";
        System.out.println("Reverse (Worst): " + practice.reverseStringWorst(testStr));
        System.out.println("Reverse (Best): " + practice.reverseStringBest(testStr));
    }
    
    // ListNode class for linked list problems
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    // ==================== TWO SUM ====================
    
    /**
     * WORST APPROACH: Brute force with nested loops
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public int[] twoSumWorst(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    /**
     * BEST APPROACH: Using HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] twoSumBest(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
    
    // ==================== MAXIMUM SUBARRAY (KADANE'S ALGORITHM) ====================
    
    /**
     * WORST APPROACH: Check all possible subarrays
     * Time Complexity: O(n³)
     * Space Complexity: O(1)
     */
    public int maxSubArrayWorst(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
    
    /**
     * BEST APPROACH: Kadane's Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxSubArrayBest(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    // ==================== VALID PARENTHESES ====================
    
    /**
     * WORST APPROACH: Using multiple counters
     * Time Complexity: O(n)
     * Space Complexity: O(1) - but doesn't handle all cases correctly
     */
    public boolean isValidParenthesesWorst(String s) {
        int round = 0, square = 0, curly = 0;
        
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': round++; break;
                case ')': round--; break;
                case '[': square++; break;
                case ']': square--; break;
                case '{': curly++; break;
                case '}': curly--; break;
            }
            
            if (round < 0 || square < 0 || curly < 0) {
                return false;
            }
        }
        
        return round == 0 && square == 0 && curly == 0;
    }
    
    /**
     * BEST APPROACH: Using stack
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isValidParenthesesBest(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    // ==================== MERGE TWO SORTED LISTS ====================
    
    /**
     * WORST APPROACH: Create new list with all values, then sort
     * Time Complexity: O((m+n) log(m+n))
     * Space Complexity: O(m+n)
     */
    public ListNode mergeTwoListsWorst(ListNode l1, ListNode l2) {
        List<Integer> values = new ArrayList<>();
        
        // Collect all values
        ListNode current = l1;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        current = l2;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        // Sort values
        Collections.sort(values);
        
        // Create new list
        if (values.isEmpty()) return null;
        
        ListNode head = new ListNode(values.get(0));
        current = head;
        for (int i = 1; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
        
        return head;
    }
    
    /**
     * BEST APPROACH: Merge in-place using two pointers
     * Time Complexity: O(m+n)
     * Space Complexity: O(1)
     */
    public ListNode mergeTwoListsBest(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    // ==================== REVERSE STRING ====================
    
    /**
     * WORST APPROACH: Using extra string concatenation
     * Time Complexity: O(n²) due to string concatenation
     * Space Complexity: O(n)
     */
    public String reverseStringWorst(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i); // Inefficient string concatenation
        }
        return result;
    }
    
    /**
     * BEST APPROACH: Using StringBuilder
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String reverseStringBest(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    
    // ==================== ADDITIONAL PRACTICE PROBLEMS ====================
    
    /**
     * WORST APPROACH: Check all possible palindromes
     * Time Complexity: O(n³)
     * Space Complexity: O(1)
     */
    public String longestPalindromeWorst(String s) {
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        
        return longest;
    }
    
    /**
     * BEST APPROACH: Expand around center
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public String longestPalindromeBest(String s) {
        if (s == null || s.length() < 2) return s;
        
        int start = 0, maxLength = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > maxLength) {
                start = i - (len - 1) / 2;
                maxLength = len;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * WORST APPROACH: Check all possible combinations
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> combinationSumWorst(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void combinationSumHelper(int[] candidates, int target, int start, 
                                    List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * BEST APPROACH: Backtracking with pruning
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> combinationSumBest(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort for pruning
        combinationSumBacktrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void combinationSumBacktrack(int[] candidates, int target, int start,
                                       List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break; // Pruning
            
            current.add(candidates[i]);
            combinationSumBacktrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    // ==================== UTILITY METHODS ====================
    
    public ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        
        return head;
    }
    
    public String listToString(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        return values.toString();
    }
    
    /**
     * WORST APPROACH: Check all possible paths
     * Time Complexity: O(2^(m+n))
     * Space Complexity: O(m+n)
     */
    public int uniquePathsWorst(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePathsWorst(m - 1, n) + uniquePathsWorst(m, n - 1);
    }
    
    /**
     * BEST APPROACH: Dynamic programming
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     */
    public int uniquePathsBest(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Fill first row and column with 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
} 