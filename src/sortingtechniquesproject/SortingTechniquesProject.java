package sortingtechniquesproject;

import java.util.Scanner;

public class SortingTechniquesProject {


      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input array size: ");
        int size = scanner.nextInt();
        
        while (size <= 0) {
        System.out.print(" Enter array size again (must be greater than 0): ");
        size = scanner.nextInt();

        if (size <= 0) {
        System.out.println("Invalid input. Please enter a number greater than 0.");
    }
}
        
        int[] numbers = new int[size];
        
        System.out.println("input array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println();
        System.out.println("Sorting Techniques:");
        

        int[] bubbleSortedNumbers = numbers.clone();
        bubblesort(bubbleSortedNumbers);
        System.out.print("bubblesort: ");
        printArray(bubbleSortedNumbers);
        

        int[] quickSortedNumbers = numbers.clone();
        quickSort(quickSortedNumbers, 0, quickSortedNumbers.length - 1);
        System.out.print("quickSort: ");
        printArray(quickSortedNumbers);
        

        int[] selectionSortedNumbers = numbers.clone();
        selectionSort(selectionSortedNumbers);
        System.out.print("selectionSort: ");
        printArray(selectionSortedNumbers);
        

        int[] insertionSortedNumbers = numbers.clone();
        insertionSort(insertionSortedNumbers);
        System.out.print("insertionSort: ");
        printArray(insertionSortedNumbers);
        
        int[] mergeSortedNumbers = numbers.clone();
        mergeSort(mergeSortedNumbers);
        System.out.print("mergeSort: ");
        printArray(mergeSortedNumbers);
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    

    public static int[] bubblesort(int[] numbers) {
    boolean swapped = true;
    long startTime = System.nanoTime();
    for (int i = 0; i < numbers.length - 1 && swapped; i++) {
        swapped = false;
        for (int j = 0; j < numbers.length - i - 1; j++) {
            if (numbers[j + 1] < numbers[j]) {
                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
                swapped = true;
            }
        }
    }
    long endTime = System.nanoTime();
    System.out.println("Time taken for Bubble Sort: " + (endTime - startTime) + " nanoseconds");
    return numbers;
}

    
    public static int[] selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest_element_index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[smallest_element_index])
                    smallest_element_index = j;
            int smallestNumber = arr[smallest_element_index];
            arr[smallest_element_index] = arr[i];
            arr[i] = smallestNumber;
        }
        return arr ;
    }

    
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            int cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = cur;
        }
    }

    public static int[] mergeSort(int[] inputArray) {
        int size = inputArray.length;
        if (size < 2){
            if(size==1)
                return inputArray;
            return null;              }
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for (int i = 0; i < mid; i++) {
            left[i] = inputArray[i];
        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = inputArray[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, inputArray);
        return inputArray;
    }
    
public static int[] merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
        return arr;
        
    }
    
    public static int[] quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
    return arr;
}

private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
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
}}
