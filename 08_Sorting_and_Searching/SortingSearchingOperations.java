import java.util.*;

/**
 * Sorting and Searching Operations - Both worst and best approaches
 */
public class SortingSearchingOperations {
    public static void main(String[] args) {
        SortingSearchingOperations ops = new SortingSearchingOperations();
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();
        int[] arr6 = arr.clone();
        int[] arr7 = arr.clone();

        System.out.println("Original: " + Arrays.toString(arr));
        ops.bubbleSortWorst(arr2.clone());
        ops.bubbleSortBest(arr2.clone());
        ops.insertionSortWorst(arr3.clone());
        ops.insertionSortBest(arr3.clone());
        ops.selectionSortWorst(arr4.clone());
        ops.selectionSortBest(arr4.clone());
        ops.mergeSort(arr5.clone());
        ops.quickSort(arr6.clone());

        int[] searchArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\nLinear Search (Worst): " + ops.linearSearchWorst(searchArr, 7));
        System.out.println("Linear Search (Best): " + ops.linearSearchBest(searchArr, 7));
        System.out.println("Binary Search (Worst): " + ops.binarySearchWorst(searchArr, 7));
        System.out.println("Binary Search (Best): " + ops.binarySearchBest(searchArr, 7));
    }

    // Bubble Sort
    public void bubbleSortWorst(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble Sort (Worst): " + Arrays.toString(arr));
    }
    public void bubbleSortBest(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Bubble Sort (Best): " + Arrays.toString(arr));
    }

    // Insertion Sort
    public void insertionSortWorst(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        System.out.println("Insertion Sort (Worst): " + Arrays.toString(arr));
    }
    public void insertionSortBest(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Insertion Sort (Best): " + Arrays.toString(arr));
    }

    // Selection Sort
    public void selectionSortWorst(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Selection Sort (Worst): " + Arrays.toString(arr));
    }
    public void selectionSortBest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        System.out.println("Selection Sort (Best): " + Arrays.toString(arr));
    }

    // Merge Sort
    public void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(arr));
    }
    private void mergeSortHelper(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortHelper(arr, l, m);
            mergeSortHelper(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort
    public void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(arr));
    }
    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Linear Search
    public int linearSearchWorst(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    public int linearSearchBest(int[] arr, int target) {
        // If sorted, can break early
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
            if (arr[i] > target) break;
        }
        return -1;
    }

    // Binary Search
    public int binarySearchWorst(int[] arr, int target) {
        // Linear search (worst for sorted array)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    public int binarySearchBest(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
} 