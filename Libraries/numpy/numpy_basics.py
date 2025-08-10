# NumPy Basics Example
# Demonstrates: Array creation, mathematical operations, array manipulation, broadcasting

import numpy as np

print("=== NumPy Basics Example ===\n")

# 1. Creating Arrays
print("1. Creating Arrays:")
print("-" * 30)

# From Python lists
arr1 = np.array([1, 2, 3, 4, 5])
print("1D array from list:", arr1)
print("Shape:", arr1.shape)
print("Data type:", arr1.dtype)

# 2D array
arr2d = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print("\n2D array:")
print(arr2d)
print("Shape:", arr2d.shape)

# Using numpy functions
zeros_arr = np.zeros((3, 4))
print("\nZeros array (3x4):")
print(zeros_arr)

ones_arr = np.ones((2, 3))
print("\nOnes array (2x3):")
print(ones_arr)

# Range arrays
range_arr = np.arange(0, 10, 2)  # start, stop, step
print("\nRange array (0 to 10, step 2):", range_arr)

linspace_arr = np.linspace(0, 1, 5)  # start, stop, num_points
print("Linspace array (0 to 1, 5 points):", linspace_arr)

# Random arrays
random_arr = np.random.rand(3, 3)
print("\nRandom array (3x3):")
print(random_arr)

# 2. Array Operations
print("\n2. Array Operations:")
print("-" * 30)

# Basic arithmetic
a = np.array([1, 2, 3, 4])
b = np.array([5, 6, 7, 8])

print("Array a:", a)
print("Array b:", b)
print("Addition (a + b):", a + b)
print("Subtraction (a - b):", a - b)
print("Multiplication (a * b):", a * b)
print("Division (a / b):", a / b)
print("Power (a ** 2):", a ** 2)

# Broadcasting
print("\nBroadcasting example:")
arr_2d = np.array([[1, 2, 3], [4, 5, 6]])
scalar = 2
print("2D array:")
print(arr_2d)
print("Scalar:", scalar)
print("Array + scalar:")
print(arr_2d + scalar)

# 3. Array Indexing and Slicing
print("\n3. Array Indexing and Slicing:")
print("-" * 30)

# 1D array indexing
arr = np.array([10, 20, 30, 40, 50, 60, 70, 80, 90, 100])
print("Original array:", arr)
print("First element:", arr[0])
print("Last element:", arr[-1])
print("Slice [2:5]:", arr[2:5])
print("Slice [::2] (every 2nd):", arr[::2])
print("Slice [::-1] (reverse):", arr[::-1])

# 2D array indexing
matrix = np.array([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
print("\n2D array:")
print(matrix)
print("Element at [1, 2]:", matrix[1, 2])
print("Row 1:", matrix[1, :])
print("Column 2:", matrix[:, 2])
print("Submatrix [0:2, 1:3]:")
print(matrix[0:2, 1:3])

# 4. Mathematical Functions
print("\n4. Mathematical Functions:")
print("-" * 30)

# Trigonometric functions
angles = np.array([0, 30, 45, 60, 90])
angles_rad = np.radians(angles)
print("Angles (degrees):", angles)
print("Sin:", np.sin(angles_rad))
print("Cos:", np.cos(angles_rad))
print("Tan:", np.tan(angles_rad))

# Statistical functions
data = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
print("\nData:", data)
print("Mean:", np.mean(data))
print("Median:", np.median(data))
print("Standard deviation:", np.std(data))
print("Variance:", np.var(data))
print("Min:", np.min(data))
print("Max:", np.max(data))
print("Sum:", np.sum(data))

# 5. Array Manipulation
print("\n5. Array Manipulation:")
print("-" * 30)

# Reshaping
arr_flat = np.arange(12)
print("Original array:", arr_flat)
print("Reshaped to 3x4:")
print(arr_flat.reshape(3, 4))
print("Reshaped to 2x6:")
print(arr_flat.reshape(2, 6))

# Transpose
matrix_2d = np.array([[1, 2, 3], [4, 5, 6]])
print("\nOriginal matrix:")
print(matrix_2d)
print("Transposed matrix:")
print(matrix_2d.T)

# Flatten
print("\nFlattened matrix:")
print(matrix_2d.flatten())

# 6. Boolean Indexing
print("\n6. Boolean Indexing:")
print("-" * 30)

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
print("Original array:", arr)

# Boolean mask
mask = arr > 5
print("Boolean mask (arr > 5):", mask)
print("Filtered array (arr > 5):", arr[mask])

# Multiple conditions
mask2 = (arr > 3) & (arr < 8)
print("Multiple conditions (3 < arr < 8):", arr[mask2])

# 7. Array Methods
print("\n7. Array Methods:")
print("-" * 30)

# Sorting
unsorted = np.array([3, 1, 4, 1, 5, 9, 2, 6])
print("Unsorted array:", unsorted)
print("Sorted array:", np.sort(unsorted))
print("Sort in place:")
unsorted.sort()
print("After sorting:", unsorted)

# Unique values
arr_with_duplicates = np.array([1, 2, 2, 3, 3, 3, 4, 5])
print("\nArray with duplicates:", arr_with_duplicates)
print("Unique values:", np.unique(arr_with_duplicates))

# 8. Linear Algebra
print("\n8. Linear Algebra:")
print("-" * 30)

# Matrix operations
A = np.array([[1, 2], [3, 4]])
B = np.array([[5, 6], [7, 8]])

print("Matrix A:")
print(A)
print("Matrix B:")
print(B)
print("Matrix multiplication (A @ B):")
print(A @ B)
print("Element-wise multiplication (A * B):")
print(A * B)

# Determinant and inverse
print("\nDeterminant of A:", np.linalg.det(A))
print("Inverse of A:")
print(np.linalg.inv(A))

# Eigenvalues and eigenvectors
eigenvals, eigenvecs = np.linalg.eig(A)
print("\nEigenvalues of A:", eigenvals)
print("Eigenvectors of A:")
print(eigenvecs)

# 9. Random Number Generation
print("\n9. Random Number Generation:")
print("-" * 30)

# Set seed for reproducibility
np.random.seed(42)

print("Random integers (1-10):", np.random.randint(1, 11, 5))
print("Random floats (0-1):", np.random.random(5))
print("Normal distribution (mean=0, std=1):", np.random.normal(0, 1, 5))
print("Uniform distribution (0-10):", np.random.uniform(0, 10, 5))

# 10. Saving and Loading Arrays
print("\n10. Saving and Loading Arrays:")
print("-" * 30)

# Save array
save_arr = np.array([[1, 2, 3], [4, 5, 6]])
np.save('Libraries/numpy/saved_array.npy', save_arr)
print("Array saved to saved_array.npy")

# Load array
loaded_arr = np.load('Libraries/numpy/saved_array.npy')
print("Loaded array:")
print(loaded_arr)

print("\n=== NumPy Basics Complete ===") 