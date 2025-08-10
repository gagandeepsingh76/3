import java.util.*;

/**
 * Stack and Queue Operations - Demonstrating both worst and best approaches
 * This file contains implementations of common stack and queue operations and problems
 */

// Custom Stack implementation
class CustomStack {
    private int[] arr;
    private int top;
    private int capacity;
    
    public CustomStack(int size) {
        this.capacity = size;
        this.arr = new int[size];
        this.top = -1;
    }
    
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
            return;
        }
        arr[++top] = value;
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }
    
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    public int size() {
        return top + 1;
    }
}

// Custom Queue implementation
class CustomQueue {
    private int[] arr;
    private int front, rear, size, capacity;
    
    public CustomQueue(int size) {
        this.capacity = size;
        this.arr = new int[size];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }
    
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public int size() {
        return size;
    }
}

public class StackQueueOperations {
    
    public static void main(String[] args) {
        StackQueueOperations sqOps = new StackQueueOperations();
        
        // Test stack operations
        System.out.println("=== STACK OPERATIONS ===");
        sqOps.testStackOperations();
        
        // Test queue operations
        System.out.println("\n=== QUEUE OPERATIONS ===");
        sqOps.testQueueOperations();
        
        // Test valid parentheses
        System.out.println("\n=== VALID PARENTHESES ===");
        String[] testStrings = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String s : testStrings) {
            System.out.println(s + " (Worst): " + sqOps.isValidParenthesesWorst(s));
            System.out.println(s + " (Best): " + sqOps.isValidParenthesesBest(s));
        }
        
        // Test min stack
        System.out.println("\n=== MIN STACK ===");
        sqOps.testMinStack();
    }
    
    // ==================== STACK OPERATIONS ====================
    
    public void testStackOperations() {
        CustomStack stack = new CustomStack(5);
        
        System.out.println("Pushing elements: 1, 2, 3, 4, 5");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        
        System.out.println("Popping elements:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
    
    // ==================== QUEUE OPERATIONS ====================
    
    public void testQueueOperations() {
        CustomQueue queue = new CustomQueue(5);
        
        System.out.println("Enqueuing elements: 1, 2, 3, 4, 5");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        
        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element: " + queue.peek());
        
        System.out.println("Dequeuing elements:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
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
    
    // ==================== MIN STACK ====================
    
    /**
     * WORST APPROACH: Using two stacks
     * Time Complexity: O(1) for all operations
     * Space Complexity: O(n) - extra space for min stack
     */
    class MinStackWorst {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStackWorst() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }
        
        public void pop() {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
    }
    
    /**
     * BEST APPROACH: Using single stack with pairs
     * Time Complexity: O(1) for all operations
     * Space Complexity: O(n) - but more efficient
     */
    class MinStackBest {
        private Stack<int[]> stack;
        
        public MinStackBest() {
            stack = new Stack<>();
        }
        
        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new int[]{val, val});
            } else {
                int currentMin = stack.peek()[1];
                stack.push(new int[]{val, Math.min(val, currentMin)});
            }
        }
        
        public void pop() {
            stack.pop();
        }
        
        public int top() {
            return stack.peek()[0];
        }
        
        public int getMin() {
            return stack.peek()[1];
        }
    }
    
    public void testMinStack() {
        System.out.println("Testing MinStack (Worst approach):");
        MinStackWorst minStackWorst = new MinStackWorst();
        minStackWorst.push(3);
        minStackWorst.push(5);
        minStackWorst.push(2);
        minStackWorst.push(1);
        
        System.out.println("Min: " + minStackWorst.getMin());
        minStackWorst.pop();
        System.out.println("After pop, Min: " + minStackWorst.getMin());
        
        System.out.println("\nTesting MinStack (Best approach):");
        MinStackBest minStackBest = new MinStackBest();
        minStackBest.push(3);
        minStackBest.push(5);
        minStackBest.push(2);
        minStackBest.push(1);
        
        System.out.println("Min: " + minStackBest.getMin());
        minStackBest.pop();
        System.out.println("After pop, Min: " + minStackBest.getMin());
    }
    
    // ==================== IMPLEMENT STACK USING QUEUES ====================
    
    /**
     * WORST APPROACH: Using two queues with O(n) push
     * Time Complexity: O(n) push, O(1) pop
     * Space Complexity: O(n)
     */
    class StackUsingQueuesWorst {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        
        public StackUsingQueuesWorst() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        
        public void push(int x) {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        
        public int pop() {
            return q1.poll();
        }
        
        public int top() {
            return q1.peek();
        }
        
        public boolean empty() {
            return q1.isEmpty();
        }
    }
    
    /**
     * BEST APPROACH: Using single queue with O(n) push
     * Time Complexity: O(n) push, O(1) pop
     * Space Complexity: O(n)
     */
    class StackUsingQueuesBest {
        private Queue<Integer> queue;
        
        public StackUsingQueuesBest() {
            queue = new LinkedList<>();
        }
        
        public void push(int x) {
            queue.offer(x);
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
        }
        
        public int pop() {
            return queue.poll();
        }
        
        public int top() {
            return queue.peek();
        }
        
        public boolean empty() {
            return queue.isEmpty();
        }
    }
    
    // ==================== IMPLEMENT QUEUE USING STACKS ====================
    
    /**
     * WORST APPROACH: Using two stacks with O(n) dequeue
     * Time Complexity: O(1) enqueue, O(n) dequeue
     * Space Complexity: O(n)
     */
    class QueueUsingStacksWorst {
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        
        public QueueUsingStacksWorst() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        public void enqueue(int x) {
            s1.push(x);
        }
        
        public int dequeue() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
        
        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
        
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
    
    /**
     * BEST APPROACH: Using two stacks with O(1) amortized dequeue
     * Time Complexity: O(1) enqueue, O(1) amortized dequeue
     * Space Complexity: O(n)
     */
    class QueueUsingStacksBest {
        private Stack<Integer> input;
        private Stack<Integer> output;
        
        public QueueUsingStacksBest() {
            input = new Stack<>();
            output = new Stack<>();
        }
        
        public void enqueue(int x) {
            input.push(x);
        }
        
        public int dequeue() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }
        
        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }
        
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
} 