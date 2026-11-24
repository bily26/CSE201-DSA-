import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class EIPAIR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {

            int elems = sc.nextInt();
            int[] arr = new int[elems];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }

            Arrays.sort(arr);
            // might be over int
            long count = 1;
            long result = 0;

            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] == arr[j]) {
                    count++;
                } else if (arr[j - 1] != arr[j]) {
                    result += kCombination(count);
                    count = 1;
                }
            }

            // the last price of the product will not check yet so add its
            result += kCombination(count);
            System.out.println(result);
        }
    }

    // To hop chap 2 cua k
    static long kCombination(long n) {
        return n * (n - 1) / 2;
    }
}
