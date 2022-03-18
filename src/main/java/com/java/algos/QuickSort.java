package com.java.algos;

/**
 * We choose an element from the list, called the pivot. We'll use it to divide the list into two sub-lists.
 * We reorder all the elements around the pivot – the ones with smaller value are placed before it,
 * and all the elements greater than the pivot after it. After this step, the pivot is in its final position. This is the important partition step.
 * We apply the above steps recursively to both sub-lists on the left and right of the pivot.
 * As we can see, quicksort is naturally a recursive algorithm, like every divide and conquer approach.
 *
 * In the best case, the algorithm will divide the list into two equal size sub-lists. So,
 * the first iteration of the full n-sized list needs O(n). Sorting the remaining two sub-lists with n/2 elements takes 2*O(n/2) each.
 * As a result, the QuickSort algorithm has the complexity of O(n log n).
 * In the worst case, the algorithm will select only one element in each iteration, so O(n) + O(n-1) + … + O(1), which is equal to O(n2).
 *
 * On the average QuickSort has O(n log n) complexity, making it suitable for big data volumes
 *
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);

    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
