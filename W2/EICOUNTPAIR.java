import java.util.Arrays;
import java.util.Scanner;

public class EICOUNTPAIR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long target = sc.nextLong();
        count = twoPointersReturnNumbPair(arr, target);
        System.out.println(count);
    }

    // TwoPointer just check elem 1 times
    static long twoPointersReturnNumbPair(long[] a, long target) {
        int i = 0, j = a.length - 1;
        // count could be over integer -> long
        long count = 0;
        while (i < j) {
            if (a[i] + a[j] >= target) {
                j--;
            } else {
                // this case if the a[i]+a[j] satisfied count= j-i means total elem satisfied
                // the condition
                count += j - i;
                i++;// when i increase still able to have the other pairsum satisfied the target
            }
        }
        return count;
    }
}
