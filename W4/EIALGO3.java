import java.util.Arrays;
import java.util.Scanner;

public class EIALGO3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        int testCases = sc.nextInt();
        int[] arr = new int[elems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // PrefixSum array
        long[] pfs = new long[arr.length];// Sum might 2 int maybe a long
        for (int j = 0; j < pfs.length; j++) {
            if (j == 0) {
                pfs[0] = arr[0];
            } else {
                pfs[j] = pfs[j - 1] + arr[j];
            }
        }
        // ArraySorted from arr
        int[] newArr = arr.clone();
        Arrays.sort(newArr);

        for (int i = 0; i < testCases; i++) {
            String nameAlgo = sc.next();
            switch (nameAlgo) {
                case "SlidingWindow":
                    int sWSize = sc.nextInt();
                    sb.append(sumMaxArraySwSize(arr, sWSize) + "\n");
                    break;
                case "TwoPointer":
                    long requireNumb = sc.nextLong();
                    int left = 0, right = newArr.length - 1;
                    int minPa = -1, minPb = -1;
                    int pair = 0;
                    while (left < right) {
                        pair = newArr[left] + newArr[right];
                        if (pair == requireNumb) {
                            minPa = newArr[left];
                            minPb = newArr[right];
                            // if they need the index that closet it can be wrong exp: 1 1 3 4 target : 4
                            // output index 1 and 2
                            left++;
                            right--;
                        }
                        if (pair > requireNumb) {
                            right--;
                        } else if (pair < requireNumb) {
                            left++;
                        }
                    }
                    // lambda Expression
                    // ? stand for if it right -> do the statement after ?
                    // : wrong do the statement
                    sb.append(minPa + " " + minPb + "\n");
                    break;
                case "PrefixSum":
                    int start = sc.nextInt(), end = sc.nextInt();
                    sb.append(sumFromAToB(pfs, start, end) + "\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }

    static long sumMaxArraySwSize(int[] array, int sWSize) {
        long sum = 0;
        long maxSum = 0;
        for (int j = 0; j < sWSize; j++) {
            sum += array[j];
        }
        maxSum = sum;
        for (int i = 1; i <= array.length - sWSize; i++) {
            maxSum = Math.max(maxSum, sum += array[i + sWSize - 1] - array[i - 1]);
        }
        return maxSum;
    }

    static long sumFromAToB(long[] prefixSum, int left, int right) {
        long result = 0;
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
}
