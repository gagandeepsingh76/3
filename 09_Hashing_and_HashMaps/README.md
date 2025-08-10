# Hashing and HashMaps

This folder contains implementations of hash tables and hash-based data structures.

## 📁 Contents

### HashMap Implementation

#### Custom HashMap (`Hash Map/function.java`)
- **Language:** Java
- **Features:**
  - Generic implementation (supports any key-value types)
  - Separate chaining for collision resolution
  - Dynamic resizing (rehashing)
  - Load factor management
  - Basic operations: put, get, remove, containsKey
- **Time Complexity:**
  - Average: O(1) for all operations
  - Worst case: O(n) due to collisions
- **Space Complexity:** O(n)

## 🔧 Implementation Details

### Key Features:
1. **Generic Types:** Uses Java generics for type safety
2. **Hash Function:** Uses built-in hashCode() with modulo operation
3. **Collision Resolution:** Separate chaining with LinkedList
4. **Dynamic Resizing:** Automatically resizes when load factor > 2.0
5. **Rehashing:** Redistributes elements when resizing

### Methods Available:
- `put(K key, V value)` - Insert or update key-value pair
- `get(K key)` - Retrieve value for given key
- `remove(K key)` - Remove key-value pair
- `containsKey(K key)` - Check if key exists
- `isEmpty()` - Check if map is empty
- `keySet()` - Get all keys

## 📚 Additional Resources

- [Hash Table Wikipedia](https://en.wikipedia.org/wiki/Hash_table)
- [Java HashMap Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)

## 🚀 Practice Problems

1. Implement a HashSet
2. Find first non-repeating character
3. Group anagrams
4. Two sum problem
5. Longest substring without repeating characters

## 🔍 Common Hash Table Applications

- **Caching:** Fast lookups for frequently accessed data
- **Database Indexing:** Quick record retrieval
- **Symbol Tables:** Compiler implementations
- **Deduplication:** Removing duplicate elements
- **Frequency Counting:** Counting occurrences

---

*Add more hash table implementations here!* 