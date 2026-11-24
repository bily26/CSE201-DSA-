import java.util.Scanner;

public class EIPFS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int queries = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // PrefixingSum
        // Normal Case prefixing sum
        long[] pfs = new long[arr.length];
        for (int i = 0; i < pfs.length; i++) {
            if (i < 1) {
                pfs[i] = arr[i];
            } else {
                pfs[i] = pfs[i - 1] + arr[i];
            }
        }
        // Solve each query
        long value = 0;
        for (int i = 0; i < queries; i++) {
            int start = sc.nextInt(), end = sc.nextInt();
            // Same location
            if (start == end) {
                value = arr[start];
                sb.append(value + "\n");
            } // From beginning sum= value at idx that ends
            else if (start == 0) {
                value = pfs[end];
                sb.append(value + "\n");
            } else {
                // from start=x to end=y;
                value = pfs[end] - pfs[start - 1];
                sb.append(value + "\n");
            }
        }
        System.out.println(sb);
    }
}
