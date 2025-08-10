# Comprehensive DSA Repository with Java Implementations

## 🎯 Overview

This repository contains **complete Java implementations** of Data Structures and Algorithms concepts with **both worst and best approaches** for each problem. Every category includes:

- ✅ **Worst Approach**: Demonstrates inefficient solutions for learning purposes
- ✅ **Best Approach**: Shows optimized, production-ready solutions
- ✅ **Time & Space Complexity Analysis**: Detailed complexity explanations
- ✅ **Working Examples**: Complete test cases and demonstrations

## 📁 Complete Implementation Guide

### 01_Arrays_and_Strings
**Files:**
- `ArrayOperations.java` - Array manipulation algorithms
- `StringOperations.java` - String processing algorithms

**Key Implementations:**
- **Array Operations:**
  - Reverse array (Worst: O(n²), Best: O(n))
  - Find maximum (Worst: O(n log n), Best: O(n))
  - Two sum (Worst: O(n²), Best: O(n))
  - Move zeros (Worst: O(n), Best: O(n))
  - Duplicate detection (Worst: O(n²), Best: O(n))
  - Missing number (Worst: O(n log n), Best: O(n))

- **String Operations:**
  - String reversal (Worst: O(n²), Best: O(n))
  - Palindrome check (Worst: O(n), Best: O(n))
  - Anagram detection (Worst: O(n log n), Best: O(n))
  - First non-repeating character (Worst: O(n²), Best: O(n))
  - Longest substring without repeating (Worst: O(n³), Best: O(n))
  - String to integer (Worst: O(n), Best: O(n))

### 02_Linked_Lists
**Files:**
- `LinkedListOperations.java` - Complete linked list implementations

**Key Implementations:**
- **Basic Operations:**
  - Reverse list (Worst: O(n), Best: O(n))
  - Find middle node (Worst: O(n), Best: O(n))
  - Detect cycle (Worst: O(n), Best: O(n))
  - Remove nth from end (Worst: O(n), Best: O(n))
  - Merge sorted lists (Worst: O((m+n) log(m+n)), Best: O(m+n))
  - Insert in sorted list (Worst: O(n), Best: O(n))

### 03_Stacks_and_Queues
**Files:**
- `StackQueueOperations.java` - Stack and queue implementations

**Key Implementations:**
- **Custom Data Structures:**
  - Custom Stack implementation
  - Custom Queue implementation
  - Valid parentheses (Worst: O(n), Best: O(n))
  - Min stack (Worst: O(1), Best: O(1))
  - Stack using queues (Worst: O(n), Best: O(n))
  - Queue using stacks (Worst: O(n), Best: O(1) amortized)

### 04_Trees_and_Graphs
**Files:**
- `TreeOperations.java` - Complete tree algorithms

**Key Implementations:**
- **Tree Traversals:**
  - Inorder (Worst: O(n), Best: O(n))
  - Preorder (Worst: O(n), Best: O(n))
  - Postorder (Worst: O(n), Best: O(n))
  - Level order (Worst: O(n²), Best: O(n))

- **Tree Properties:**
  - Maximum depth (Worst: O(n), Best: O(n))
  - Symmetric tree check (Worst: O(n), Best: O(n))
  - Valid BST (Worst: O(n), Best: O(n))
  - Path to node (Worst: O(n), Best: O(n))

### 05_Recursion_and_Backtracking
**Files:**
- `RecursionOperations.java` - Recursion and backtracking algorithms

**Key Implementations:**
- **Basic Recursion:**
  - Factorial (Worst: O(n), Best: O(n))
  - Fibonacci (Worst: O(2ⁿ), Best: O(n))
  - Power (Worst: O(n), Best: O(log n))
  - GCD (Worst: O(min(a,b)), Best: O(log(min(a,b))))

- **Backtracking:**
  - Permutations (Worst: O(n!), Best: O(n!))
  - Subsets (Worst: O(n * 2ⁿ), Best: O(n * 2ⁿ))
  - N-Queens (Worst: O(nⁿ), Best: O(n!))
  - Combination sum (Worst: O(2ⁿ), Best: O(2ⁿ))

### 06_Dynamic_Programming
**Files:**
- `DynamicProgrammingOperations.java` - DP algorithms

**Key Implementations:**
- **Classic DP Problems:**
  - Fibonacci (Worst: O(2ⁿ), Best: O(n))
  - Climbing stairs (Worst: O(2ⁿ), Best: O(n))
  - Coin change (Worst: O(amount * n), Best: O(amount * n))
  - Longest common subsequence (Worst: O(m*n), Best: O(m*n))
  - Longest increasing subsequence (Worst: O(n²), Best: O(n log n))
  - 0/1 Knapsack (Worst: O(n*capacity), Best: O(n*capacity))
  - Edit distance (Worst: O(3^(m+n)), Best: O(m*n))
  - Matrix chain multiplication (Worst: O(4ⁿ), Best: O(n³))

### 07_Greedy_Algorithms
**Files:**
- `GreedyOperations.java` - Greedy algorithm implementations

**Key Implementations:**
- **Greedy Problems:**
  - Activity selection (Worst: O(2ⁿ), Best: O(n log n))
  - Fractional knapsack (Worst: O(2ⁿ), Best: O(n log n))
  - Huffman coding (Worst: O(n²), Best: O(n log n))
  - Kruskal's MST (Worst: O(E^(V-1)), Best: O(E log E))
  - Dijkstra's shortest path (Worst: O(V!), Best: O((V+E) log V))
  - Coin change greedy (Worst: O(amountⁿ), Best: O(n log n))

### 08_Sorting_and_Searching
**Files:**
- `insertionSort.c` - Insertion sort implementation
- `quickSort.c` - Quick sort template
- `README.md` - Detailed documentation

**Key Implementations:**
- **Sorting Algorithms:**
  - Insertion Sort (O(n²) worst, O(n) best)
  - Quick Sort (O(n log n) average, O(n²) worst)
  - Ready for: Binary Search, Linear Search, Jump Search

### 09_Hashing_and_HashMaps
**Files:**
- `Hash Map/function.java` - Custom HashMap implementation
- `README.md` - Detailed documentation

**Key Implementation:**
- **Custom HashMap:**
  - Generic implementation with generics
  - Separate chaining for collision resolution
  - Dynamic resizing and rehashing
  - All basic operations: put, get, remove, containsKey

### 10_Practice_Questions
**Files:**
- `PracticeProblems.java` - Collection of common interview problems
- `Practice Sheet 1 For DSA.xlsx` - Practice problems sheet

**Key Implementations:**
- **Common Interview Problems:**
  - Two Sum (Worst: O(n²), Best: O(n))
  - Maximum Subarray (Worst: O(n³), Best: O(n))
  - Valid Parentheses (Worst: O(n), Best: O(n))
  - Merge Two Sorted Lists (Worst: O((m+n) log(m+n)), Best: O(m+n))
  - Reverse String (Worst: O(n²), Best: O(n))
  - Longest Palindrome (Worst: O(n³), Best: O(n²))
  - Combination Sum (Worst: O(2ⁿ), Best: O(2ⁿ))
  - Unique Paths (Worst: O(2^(m+n)), Best: O(m*n))

### 11_Notes_and_Resources
**Files:**
- `DSA-Handwritten-Notes.pdf` - Comprehensive handwritten notes
- `Java DSA LeetCode Roadmap.html` - Learning roadmap
- `Java DSA LeetCode Roadmap_files/` - Supporting files

## 🚀 How to Use This Repository

### 1. **Learning Path**
```
01_Arrays_and_Strings → 02_Linked_Lists → 03_Stacks_and_Queues → 
08_Sorting_and_Searching → 04_Trees_and_Graphs → 05_Recursion_and_Backtracking → 
06_Dynamic_Programming → 07_Greedy_Algorithms → 09_Hashing_and_HashMaps → 
10_Practice_Questions
```

### 2. **For Each Problem**
1. **Read the worst approach** - Understand the naive solution
2. **Analyze the complexity** - See why it's inefficient
3. **Study the best approach** - Learn the optimized solution
4. **Run the examples** - Test with provided test cases
5. **Practice variations** - Try similar problems

### 3. **Compilation and Execution**
```bash
# Compile Java files
javac *.java

# Run specific class
java ArrayOperations
java LinkedListOperations
java TreeOperations
# ... etc
```

## 📊 Complexity Analysis Summary

| Category | Worst Time | Best Time | Space Complexity |
|----------|------------|-----------|------------------|
| Arrays & Strings | O(n²) - O(n³) | O(n) - O(n log n) | O(1) - O(n) |
| Linked Lists | O(n) - O(n²) | O(n) | O(1) - O(n) |
| Stacks & Queues | O(n) | O(1) - O(n) | O(1) - O(n) |
| Trees & Graphs | O(n) - O(n²) | O(n) | O(h) - O(n) |
| Recursion | O(2ⁿ) - O(n!) | O(n) - O(n log n) | O(n) - O(n²) |
| Dynamic Programming | O(2ⁿ) - O(nⁿ) | O(n) - O(n³) | O(1) - O(n²) |
| Greedy | O(2ⁿ) - O(V!) | O(n log n) - O((V+E) log V) | O(1) - O(n) |

## 🎯 Key Learning Objectives

### ✅ **Understanding Complexity**
- Learn to identify inefficient algorithms
- Understand trade-offs between time and space
- Recognize when to use different approaches

### ✅ **Problem-Solving Skills**
- Break down complex problems
- Identify patterns and similarities
- Choose appropriate data structures

### ✅ **Implementation Skills**
- Write clean, readable code
- Handle edge cases properly
- Optimize for performance

### ✅ **Interview Preparation**
- Master common DSA problems
- Understand both naive and optimal solutions
- Practice with real-world examples

## 🔧 Additional Features

### **Code Quality**
- ✅ Well-documented with comments
- ✅ Consistent coding style
- ✅ Proper error handling
- ✅ Comprehensive test cases

### **Educational Value**
- ✅ Side-by-side worst vs best approaches
- ✅ Detailed complexity explanations
- ✅ Real-world problem examples
- ✅ Progressive difficulty levels

### **Practical Applications**
- ✅ Interview preparation
- ✅ Academic learning
- ✅ Professional development
- ✅ Algorithm design practice

## 📚 Recommended Study Plan

### **Week 1-2: Fundamentals**
- Arrays and Strings
- Basic linked list operations
- Simple sorting algorithms

### **Week 3-4: Data Structures**
- Stacks and Queues
- Trees and basic traversals
- Hash tables and maps

### **Week 5-6: Advanced Concepts**
- Recursion and backtracking
- Dynamic programming basics
- Greedy algorithms

### **Week 7-8: Practice**
- Solve practice problems
- Implement variations
- Mock interviews

## 🤝 Contributing

Feel free to:
- Add new implementations
- Improve existing solutions
- Add more test cases
- Suggest optimizations
- Report bugs or issues

## 📞 Support

For questions or clarifications:
1. Check the detailed README files in each category
2. Review the code comments and documentation
3. Run the test cases to understand the behavior
4. Practice with the provided examples

---

**🎉 Happy Learning! Master DSA with both worst and best approaches!** 