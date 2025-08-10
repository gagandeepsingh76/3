/**
 * LinkedList Operations - Demonstrating both worst and best approaches
 * This file contains implementations of common linked list operations and problems
 */

// Node class for LinkedList
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListOperations {
    
    public static void main(String[] args) {
        LinkedListOperations llOps = new LinkedListOperations();
        
        // Create test linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = llOps.createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original List: ");
        llOps.printList(head);
        
        // Test reverse
        System.out.println("\nReverse List:");
        ListNode reversedWorst = llOps.reverseListWorst(head);
        System.out.println("Reverse (Worst): ");
        llOps.printList(reversedWorst);
        
        ListNode head2 = llOps.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversedBest = llOps.reverseListBest(head2);
        System.out.println("Reverse (Best): ");
        llOps.printList(reversedBest);
        
        // Test find middle
        ListNode head3 = llOps.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("\nFind Middle:");
        System.out.println("Middle (Worst): " + llOps.findMiddleWorst(head3).val);
        System.out.println("Middle (Best): " + llOps.findMiddleBest(head3).val);
        
        // Test detect cycle
        ListNode head4 = llOps.createLinkedList(new int[]{1, 2, 3, 4, 5});
        // Create cycle: 5 -> 2
        ListNode tail = head4;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head4.next; // Create cycle
        
        System.out.println("\nDetect Cycle:");
        System.out.println("Has Cycle (Worst): " + llOps.hasCycleWorst(head4));
        System.out.println("Has Cycle (Best): " + llOps.hasCycleBest(head4));
    }
    
    // ==================== UTILITY METHODS ====================
    
    public ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        
        return head;
    }
    
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // ==================== REVERSE LINKED LIST ====================
    
    /**
     * WORST APPROACH: Using extra array to store values
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public ListNode reverseListWorst(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // Store values in array
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        int[] values = new int[count];
        current = head;
        int index = 0;
        while (current != null) {
            values[index++] = current.val;
            current = current.next;
        }
        
        // Create new list with reversed values
        ListNode newHead = new ListNode(values[count - 1]);
        current = newHead;
        for (int i = count - 2; i >= 0; i--) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return newHead;
    }
    
    /**
     * BEST APPROACH: Iterative with three pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode reverseListBest(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    // ==================== FIND MIDDLE NODE ====================
    
    /**
     * WORST APPROACH: Two passes - first count, then find middle
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode findMiddleWorst(ListNode head) {
        if (head == null) return null;
        
        // First pass: count nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Second pass: find middle
        int middleIndex = count / 2;
        current = head;
        for (int i = 0; i < middleIndex; i++) {
            current = current.next;
        }
        
        return current;
    }
    
    /**
     * BEST APPROACH: Fast and slow pointer (Floyd's Tortoise and Hare)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode findMiddleBest(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // ==================== DETECT CYCLE ====================
    
    /**
     * WORST APPROACH: Using HashSet to track visited nodes
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean hasCycleWorst(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        
        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        
        return false;
    }
    
    /**
     * BEST APPROACH: Fast and slow pointer (Floyd's Cycle Detection)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean hasCycleBest(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    // ==================== REMOVE NTH NODE FROM END ====================
    
    /**
     * WORST APPROACH: Two passes - first count, then remove
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEndWorst(ListNode head, int n) {
        if (head == null) return null;
        
        // First pass: count nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Calculate position from start
        int position = count - n;
        
        if (position == 0) {
            return head.next;
        }
        
        // Second pass: remove node
        current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        current.next = current.next.next;
        return head;
    }
    
    /**
     * BEST APPROACH: One pass with two pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEndBest(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node from end
        second.next = second.next.next;
        
        return dummy.next;
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
    
    // ==================== INSERTION IN SORTED LIST ====================
    
    /**
     * WORST APPROACH: Find position, then insert
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode insertInSortedListWorst(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        
        if (head == null || value < head.val) {
            newNode.next = head;
            return newNode;
        }
        
        ListNode current = head;
        while (current.next != null && current.next.val < value) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        
        return head;
    }
    
    /**
     * BEST APPROACH: Same as worst but more efficient variable usage
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode insertInSortedListBest(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        
        if (head == null || value <= head.val) {
            newNode.next = head;
            return newNode;
        }
        
        ListNode current = head;
        while (current.next != null && current.next.val < value) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        
        return head;
    }
} 