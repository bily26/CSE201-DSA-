import java.util.Arrays;
import java.util.Scanner;

public class EIALGO1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String nameAlgori = sc.next();
        int elems = sc.nextInt();
        int testCases = sc.nextInt();
        int[] arr = new int[elems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        switch (nameAlgori) {
            case "SlidingWindow":
                for (int i = 0; i < testCases; i++) {
                    int sWSize = sc.nextInt();
                    sb.append(slidingWindow(arr, sWSize) + "\n");
                }
                break;
            case "BinarySearch":
                Arrays.sort(arr);
                for (int i = 0; i < testCases; i++) {
                    int check = sc.nextInt();
                    sb.append(binarySearch(arr, check) + "\n");
                }
                break;
            default:
                break;
        }
        System.out.println(sb);
    }

    static int slidingWindow(int[] array, int sWSize) {
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i <= array.length - sWSize; i++) {
            if (i == 0) {
                for (int j = 0; j < sWSize; j++) {
                    sum += array[j];
                }
                minSum = sum;
            } else {
                sum += array[i + sWSize - 1] - array[i - 1];
                if (minSum > sum) {
                    minSum = sum;
                }
            }
        }
        return minSum;
    }

    static int binarySearch(int[] a, int target) {
        int left = 0, right = a.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
