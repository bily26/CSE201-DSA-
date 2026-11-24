import java.util.Arrays;
import java.util.Scanner;

public class EIALGO2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String nameAlgo = sc.next();
        int elems = sc.nextInt();
        int testCases = sc.nextInt();
        int[] arr = new int[elems];
        // Origin Array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        switch (nameAlgo) {
            case "PrefixSum":
                // PrefixSum array
                int[] pfs = new int[arr.length];
                for (int j = 0; j < pfs.length; j++) {
                    if (j == 0) {
                        pfs[0] = arr[0];
                    } else {
                        pfs[j] = pfs[j - 1] + arr[j];
                    }
                }
                for (int i = 0; i < testCases; i++) {
                    int left = sc.nextInt(), right = sc.nextInt();
                    if (left == right) {
                        sb.append(arr[right] + "\n");
                    } else {
                        sb.append(sumFromAToB(pfs, left, right) + "\n");
                    }
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

    static int sumFromAToB(int[] prefixSum, int left, int right) {
        int result = 0;
        if (left == 0) {
            result = prefixSum[right];
            return result;
        } else {
            result = prefixSum[right] - prefixSum[left - 1];
            return result;
        }
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
