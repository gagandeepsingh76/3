import java.util.*;

/**
 * String Operations - Demonstrating both worst and best approaches
 * This file contains implementations of common string operations and problems
 */
public class StringOperations {
    
    public static void main(String[] args) {
        StringOperations stringOps = new StringOperations();
        
        // Test string reversal
        String testStr = "Hello World";
        System.out.println("Original String: " + testStr);
        System.out.println("Reverse (Worst): " + stringOps.reverseStringWorst(testStr));
        System.out.println("Reverse (Best): " + stringOps.reverseStringBest(testStr));
        
        // Test palindrome
        String palindrome = "racecar";
        String notPalindrome = "hello";
        System.out.println("\nPalindrome Check:");
        System.out.println(palindrome + " (Worst): " + stringOps.isPalindromeWorst(palindrome));
        System.out.println(palindrome + " (Best): " + stringOps.isPalindromeBest(palindrome));
        System.out.println(notPalindrome + " (Worst): " + stringOps.isPalindromeWorst(notPalindrome));
        System.out.println(notPalindrome + " (Best): " + stringOps.isPalindromeBest(notPalindrome));
        
        // Test anagram
        String str1 = "listen";
        String str2 = "silent";
        String str3 = "hello";
        System.out.println("\nAnagram Check:");
        System.out.println(str1 + " vs " + str2 + " (Worst): " + stringOps.isAnagramWorst(str1, str2));
        System.out.println(str1 + " vs " + str2 + " (Best): " + stringOps.isAnagramBest(str1, str2));
        System.out.println(str1 + " vs " + str3 + " (Worst): " + stringOps.isAnagramWorst(str1, str3));
        System.out.println(str1 + " vs " + str3 + " (Best): " + stringOps.isAnagramBest(str1, str3));
        
        // Test first non-repeating character
        String testChar = "leetcode";
        System.out.println("\nFirst Non-repeating Character:");
        System.out.println(testChar + " (Worst): " + stringOps.firstNonRepeatingWorst(testChar));
        System.out.println(testChar + " (Best): " + stringOps.firstNonRepeatingBest(testChar));
    }
    
    // ==================== STRING REVERSAL ====================
    
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
    
    // ==================== PALINDROME CHECK ====================
    
    /**
     * WORST APPROACH: Creating reversed string and comparing
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isPalindromeWorst(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equals(reversed);
    }
    
    /**
     * BEST APPROACH: Two-pointer technique
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
    
    // ==================== ANAGRAM CHECK ====================
    
    /**
     * WORST APPROACH: Sorting both strings
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public boolean isAnagramWorst(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
    
    /**
     * BEST APPROACH: Using character count array
     * Time Complexity: O(n)
     * Space Complexity: O(1) - fixed size array
     */
    public boolean isAnagramBest(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        
        int[] charCount = new int[26]; // Assuming lowercase letters
        
        for (char c : str1.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        for (char c : str2.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // ==================== FIRST NON-REPEATING CHARACTER ====================
    
    /**
     * WORST APPROACH: Nested loops to check each character
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public char firstNonRepeatingWorst(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean isRepeating = false;
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    isRepeating = true;
                    break;
                }
            }
            if (!isRepeating) {
                return str.charAt(i);
            }
        }
        return '\0'; // No non-repeating character found
    }
    
    /**
     * BEST APPROACH: Using HashMap to count occurrences
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public char firstNonRepeatingBest(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count occurrences
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find first non-repeating
        for (char c : str.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }
        
        return '\0'; // No non-repeating character found
    }
    
    // ==================== LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS ====================
    
    /**
     * WORST APPROACH: Check all possible substrings
     * Time Complexity: O(n³)
     * Space Complexity: O(n)
     */
    public int lengthOfLongestSubstringWorst(String str) {
        int maxLength = 0;
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (hasUniqueCharacters(substring)) {
                    maxLength = Math.max(maxLength, substring.length());
                }
            }
        }
        
        return maxLength;
    }
    
    private boolean hasUniqueCharacters(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * BEST APPROACH: Sliding window with HashSet
     * Time Complexity: O(n)
     * Space Complexity: O(min(m, n)) where m is charset size
     */
    public int lengthOfLongestSubstringBest(String str) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0, right = 0;
        
        while (right < str.length()) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }
        
        return maxLength;
    }
    
    // ==================== STRING TO INTEGER (ATOI) ====================
    
    /**
     * WORST APPROACH: Using try-catch with parseInt
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int stringToIntegerWorst(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        int i = 0;
        
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            isNegative = (str.charAt(0) == '-');
            i = 1;
        }
        
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            sb.append(str.charAt(i));
            i++;
        }
        
        if (sb.length() == 0) return 0;
        
        try {
            int result = Integer.parseInt(sb.toString());
            return isNegative ? -result : result;
        } catch (NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
    
    /**
     * BEST APPROACH: Manual parsing with overflow checking
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int stringToIntegerBest(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        
        int i = 0;
        boolean isNegative = false;
        
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            isNegative = (str.charAt(0) == '-');
            i = 1;
        }
        
        long result = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i) - '0');
            
            if (isNegative && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!isNegative && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            
            i++;
        }
        
        return isNegative ? -(int) result : (int) result;
    }
} 