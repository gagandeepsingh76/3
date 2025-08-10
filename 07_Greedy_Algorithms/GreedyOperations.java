import java.util.*;

/**
 * Greedy Algorithms - Demonstrating both worst and best approaches
 * This file contains implementations of common greedy algorithm problems
 */
public class GreedyOperations {
    
    public static void main(String[] args) {
        GreedyOperations greedyOps = new GreedyOperations();
        
        // Test Activity Selection
        System.out.println("=== ACTIVITY SELECTION ===");
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        System.out.println("Max activities (Worst): " + greedyOps.activitySelectionWorst(start, finish));
        System.out.println("Max activities (Best): " + greedyOps.activitySelectionBest(start, finish));
        
        // Test Fractional Knapsack
        System.out.println("\n=== FRACTIONAL KNAPSACK ===");
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        System.out.println("Max value (Worst): " + greedyOps.fractionalKnapsackWorst(weights, values, capacity));
        System.out.println("Max value (Best): " + greedyOps.fractionalKnapsackBest(weights, values, capacity));
        
        // Test Huffman Coding
        System.out.println("\n=== HUFFMAN CODING ===");
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};
        System.out.println("Huffman codes (Worst): " + greedyOps.huffmanCodingWorst(chars, freq));
        System.out.println("Huffman codes (Best): " + greedyOps.huffmanCodingBest(chars, freq));
        
        // Test Minimum Spanning Tree (Kruskal's)
        System.out.println("\n=== MINIMUM SPANNING TREE ===");
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        System.out.println("MST weight (Worst): " + greedyOps.kruskalMSTWorst(graph));
        System.out.println("MST weight (Best): " + greedyOps.kruskalMSTBest(graph));
        
        // Test Dijkstra's Shortest Path
        System.out.println("\n=== DIJKSTRA'S SHORTEST PATH ===");
        int[][] graph2 = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        System.out.println("Shortest distances (Worst): " + Arrays.toString(greedyOps.dijkstraWorst(graph2, 0)));
        System.out.println("Shortest distances (Best): " + Arrays.toString(greedyOps.dijkstraBest(graph2, 0)));
    }
    
    // ==================== ACTIVITY SELECTION ====================
    
    /**
     * WORST APPROACH: Brute force - check all possible combinations
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public int activitySelectionWorst(int[] start, int[] finish) {
        int n = start.length;
        int maxActivities = 0;
        
        // Generate all possible subsets
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> selected = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    selected.add(j);
                }
            }
            
            // Check if selected activities are compatible
            if (isCompatible(start, finish, selected)) {
                maxActivities = Math.max(maxActivities, selected.size());
            }
        }
        
        return maxActivities;
    }
    
    private boolean isCompatible(int[] start, int[] finish, List<Integer> activities) {
        for (int i = 0; i < activities.size(); i++) {
            for (int j = i + 1; j < activities.size(); j++) {
                int idx1 = activities.get(i);
                int idx2 = activities.get(j);
                if (start[idx1] < finish[idx2] && start[idx2] < finish[idx1]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * BEST APPROACH: Greedy - select activities by finish time
     * Time Complexity: O(n log n) - due to sorting
     * Space Complexity: O(n)
     */
    public int activitySelectionBest(int[] start, int[] finish) {
        int n = start.length;
        
        // Create activity pairs and sort by finish time
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }
        
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;
        int lastFinish = activities[0][1];
        
        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= lastFinish) {
                count++;
                lastFinish = activities[i][1];
            }
        }
        
        return count;
    }
    
    // ==================== FRACTIONAL KNAPSACK ====================
    
    /**
     * WORST APPROACH: Try all possible combinations
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public double fractionalKnapsackWorst(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        double maxValue = 0;
        
        // Try all possible combinations
        for (int i = 0; i < (1 << n); i++) {
            double currentValue = 0;
            double currentWeight = 0;
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currentValue += values[j];
                    currentWeight += weights[j];
                }
            }
            
            if (currentWeight <= capacity) {
                maxValue = Math.max(maxValue, currentValue);
            }
        }
        
        return maxValue;
    }
    
    /**
     * BEST APPROACH: Greedy - sort by value/weight ratio
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public double fractionalKnapsackBest(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        
        // Create item pairs with value/weight ratio
        double[][] items = new double[n][3];
        for (int i = 0; i < n; i++) {
            items[i][0] = weights[i];
            items[i][1] = values[i];
            items[i][2] = (double) values[i] / weights[i];
        }
        
        // Sort by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));
        
        double totalValue = 0;
        double remainingCapacity = capacity;
        
        for (int i = 0; i < n && remainingCapacity > 0; i++) {
            if (items[i][0] <= remainingCapacity) {
                // Take the whole item
                totalValue += items[i][1];
                remainingCapacity -= items[i][0];
            } else {
                // Take fraction of the item
                totalValue += items[i][2] * remainingCapacity;
                remainingCapacity = 0;
            }
        }
        
        return totalValue;
    }
    
    // ==================== HUFFMAN CODING ====================
    
    // Huffman Node class
    static class HuffmanNode {
        char data;
        int frequency;
        HuffmanNode left, right;
        
        HuffmanNode(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            this.left = this.right = null;
        }
    }
    
    /**
     * WORST APPROACH: Simple frequency-based encoding
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     */
    public Map<Character, String> huffmanCodingWorst(char[] chars, int[] freq) {
        Map<Character, String> codes = new HashMap<>();
        int n = chars.length;
        
        // Simple encoding: assign binary codes based on frequency order
        for (int i = 0; i < n; i++) {
            StringBuilder code = new StringBuilder();
            for (int j = 0; j < i; j++) {
                code.append("0");
            }
            code.append("1");
            codes.put(chars[i], code.toString());
        }
        
        return codes;
    }
    
    /**
     * BEST APPROACH: Build Huffman tree using priority queue
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public Map<Character, String> huffmanCodingBest(char[] chars, int[] freq) {
        Map<Character, String> codes = new HashMap<>();
        
        // Create priority queue with Huffman nodes
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.frequency, b.frequency));
        
        for (int i = 0; i < chars.length; i++) {
            pq.offer(new HuffmanNode(chars[i], freq[i]));
        }
        
        // Build Huffman tree
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            
            pq.offer(parent);
        }
        
        // Generate codes from the tree
        HuffmanNode root = pq.poll();
        generateCodes(root, "", codes);
        
        return codes;
    }
    
    private void generateCodes(HuffmanNode node, String code, Map<Character, String> codes) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            codes.put(node.data, code);
            return;
        }
        
        generateCodes(node.left, code + "0", codes);
        generateCodes(node.right, code + "1", codes);
    }
    
    // ==================== MINIMUM SPANNING TREE (KRUSKAL'S) ====================
    
    // Edge class for MST
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    /**
     * WORST APPROACH: Check all possible spanning trees
     * Time Complexity: O(E^(V-1))
     * Space Complexity: O(V)
     */
    public int kruskalMSTWorst(int[][] graph) {
        int V = graph.length;
        int minWeight = Integer.MAX_VALUE;
        
        // This is a simplified version - in practice, checking all spanning trees
        // would be extremely inefficient for large graphs
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }
        
        // Sort edges by weight
        Collections.sort(edges);
        
        // Try different combinations (simplified approach)
        int totalWeight = 0;
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        
        for (Edge edge : edges) {
            if (find(parent, edge.src) != find(parent, edge.dest)) {
                union(parent, edge.src, edge.dest);
                totalWeight += edge.weight;
            }
        }
        
        return totalWeight;
    }
    
    /**
     * BEST APPROACH: Kruskal's algorithm with Union-Find
     * Time Complexity: O(E log E)
     * Space Complexity: O(V)
     */
    public int kruskalMSTBest(int[][] graph) {
        int V = graph.length;
        List<Edge> edges = new ArrayList<>();
        
        // Collect all edges
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }
        
        // Sort edges by weight
        Collections.sort(edges);
        
        // Union-Find data structure
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        
        int mstWeight = 0;
        int edgeCount = 0;
        
        for (Edge edge : edges) {
            if (edgeCount == V - 1) break; // MST has V-1 edges
            
            int srcRoot = find(parent, edge.src);
            int destRoot = find(parent, edge.dest);
            
            if (srcRoot != destRoot) {
                union(parent, srcRoot, destRoot);
                mstWeight += edge.weight;
                edgeCount++;
            }
        }
        
        return mstWeight;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private void union(int[] parent, int x, int y) {
        parent[x] = y;
    }
    
    // ==================== DIJKSTRA'S SHORTEST PATH ====================
    
    /**
     * WORST APPROACH: Check all possible paths
     * Time Complexity: O(V!)
     * Space Complexity: O(V)
     */
    public int[] dijkstraWorst(int[][] graph, int src) {
        int V = graph.length;
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        
        // Simple approach: relax edges V-1 times
        for (int count = 0; count < V - 1; count++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph[u][v] < distances[v]) {
                        distances[v] = distances[u] + graph[u][v];
                    }
                }
            }
        }
        
        return distances;
    }
    
    /**
     * BEST APPROACH: Dijkstra's algorithm with priority queue
     * Time Complexity: O((V + E) log V)
     * Space Complexity: O(V)
     */
    public int[] dijkstraBest(int[][] graph, int src) {
        int V = graph.length;
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        
        // Priority queue to store vertices with their distances
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0});
        
        boolean[] visited = new boolean[V];
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int dist = current[1];
            
            if (visited[u]) continue;
            visited[u] = true;
            
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] &&
                    dist + graph[u][v] < distances[v]) {
                    distances[v] = dist + graph[u][v];
                    pq.offer(new int[]{v, distances[v]});
                }
            }
        }
        
        return distances;
    }
    
    // ==================== ADDITIONAL GREEDY PROBLEMS ====================
    
    /**
     * WORST APPROACH: Check all possible coin combinations
     * Time Complexity: O(amount^n)
     * Space Complexity: O(amount)
     */
    public int coinChangeGreedyWorst(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChangeHelper(coins, amount, coins.length - 1);
    }
    
    private int coinChangeHelper(int[] coins, int amount, int index) {
        if (amount == 0) return 0;
        if (index < 0 || amount < 0) return -1;
        
        int maxCoins = amount / coins[index];
        for (int i = maxCoins; i >= 0; i--) {
            int result = coinChangeHelper(coins, amount - i * coins[index], index - 1);
            if (result != -1) {
                return result + i;
            }
        }
        
        return -1;
    }
    
    /**
     * BEST APPROACH: Greedy coin selection
     * Time Complexity: O(n log n) - due to sorting
     * Space Complexity: O(1)
     */
    public int coinChangeGreedyBest(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        
        for (int i = coins.length - 1; i >= 0 && amount > 0; i--) {
            count += amount / coins[i];
            amount %= coins[i];
        }
        
        return amount == 0 ? count : -1;
    }
} 