//write the program to implement all sorting algorithms demonstrated in the class using an array sort
// Path: AllSortAlgo.java
public class SortingAlgorithms {
    
        public static void main(String[] args) {
            int[] arr = {5, 2, 8, 7, 1};
            bubbleSort(arr);
            System.out.println("array sorted by bubble sort algorithm:");
            printArray(arr);
            // code for printing the array sorted by selection sort
            selectionSort(arr); 
            // //add a line brake here
            // System.out.println();
            System.out.println("\narray sorted by selection sort algorithm: ");
            printArray(arr);
            // code for printing the array sorted by insertion sort
            insertionSort(arr);
            System.out.println("\narray sorted by insertion sort algorithm: ");
            printArray(arr);
            // code for printing the array sorted by quick sort
            quickSort(arr, 0, arr.length - 1);
            System.out.println("\narray sorted by quick sort algorithm: ");
            printArray(arr);
            // code for printing the array sorted by merge sort
            mergeSort(arr, 0, arr.length - 1);
            System.out.println("\narray sorted by merge sort algorithm: ");
            printArray(arr);
            // code for printing the array sorted by heap sort
            heapSort(arr);
            System.out.println("\narray sorted by heap sort algorithm: ");
            printArray(arr);
            

        }
    
        // Bubble Sort
        public static void bubbleSort(int[] arr) {
            // Implementation here
            //write the code for bubble sort
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // swap arr[j+1] and arr[i]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    
        // Selection Sort
        public static void selectionSort(int[] arr) {
            // Implementation here
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    
        // Insertion Sort
        public static void insertionSort(int[] arr) {
            // Implementation here
            int n = arr.length;
            for (int i = 1; i < n; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }
    
        // Quick Sort
        public static void quickSort(int[] arr, int low, int high) {
            // Implementation here
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }
    
        static int partition(int[] arr, int low, int high) {
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
        }

        // Merge Sort
        public static void mergeSort(int[] arr, int l, int r) {
            // Implementation here
            if (l < r) {
                int m = (l + r) / 2;
                mergeSort(arr, l, m);
                mergeSort(arr, m + 1, r);
                merge(arr, l, m, r);
            }
        }

        static void merge(int[] arr, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;
            int L[] = new int[n1];
            int R[] = new int[n2];
            for (int i = 0; i < n1; ++i) {
                L[i] = arr[l + i];
            }
            for (int j = 0; j < n2; ++j) {
                R[j] = arr[m + 1 + j];
            }
            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        // Heap Sort
        public static void heapSort(int[] arr) {
            // Implementation here
            int n = arr.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }
            for (int i = n - 1; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, i, 0);
            }
        }

        static void heapify(int[] arr, int n, int i) {
            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < n && arr[l] > arr[largest]) {
                largest = l;
            }
            if (r < n && arr[r] > arr[largest]) {
                largest = r;
            }
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;
                heapify(arr, n, largest);
            }
        }

        static void printArray(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    