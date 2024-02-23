import java.util.Scanner;

public class SearchingAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be searched: ");
        int x = sc.nextInt();
        int result = linearSearch(arr, x);
        if (result == -1) {
            System.out.println("Number " + x + " is not present in array");
        } else {
            System.out.println("Number " + x + " is at index " + result);
        }
        result = binarySearch(arr, x);
        if (result == -1) {
            System.out.println("Number " + x + " is not present in array");
        } else {
            System.out.println("Number " + x + " is at index " + result);
        }
        result = jumpSearch(arr, x);
        if (result == -1) {
            System.out.println("Number " + x + " is not present in array");
        } else {
            System.out.println("Number " + x + " is at index " + result);
        }
        result = interpolationSearch(arr, x);
        if (result == -1) {
            System.out.println("Number " + x + " is not present in array");
        } else {
            System.out.println("Number " + x + "is at index " + result);
        }
        sc.close();
    }

    // Linear Search
    public static int linearSearch(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int x) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) {
                return m;
            }
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    // Jump Search
    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }
        while (arr[prev] < x) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }
        if (arr[prev] == x) {
            return prev;
        }
        return -1;
    }

    // Interpolation Search
    public static int interpolationSearch(int[] arr, int x) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r && x >= arr[l] && x <= arr[r]) {
            if (l == r) {
                if (arr[l] == x) {
                    return l;
                }
                return -1;
            }
            int pos = l + ((x - arr[l]) * (r - l) / (arr[r] - arr[l]));
            if (arr[pos] == x) {
                return pos;
            }
            if (arr[pos] < x) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        return -1;
    }
}
