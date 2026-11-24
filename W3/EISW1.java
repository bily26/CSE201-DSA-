import java.util.Arrays;
import java.util.Scanner;

public class EISW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int swSize = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int minDif = Integer.MAX_VALUE;

        // Sliding window
        /*
         * The condition is n-Sliding window size, due to, avoiding outbound when it
         * reached the end of the array and condition make it has the rest enough to
         */
        // The special case when array size = 1 and Sliding window = 1 so the loop will
        // end when it started. (1)
        // calculate
        // Example: n = 5, sWSize=3
        // i-> 5-3=2 means it will take 3 elem and the rest is 2
        for (int i = 0; i <= n - swSize; i++) {
            // From (1) So it just go though and start the i = 1 to end the array
            int min = theDifOf2Numbs(arr[i], arr[i + swSize - 1]);
            if (minDif > min) {
                minDif = min;
            }
        }
        System.out.println(minDif);
    }

    static int theDifOf2Numbs(int a, int b) {
        return Math.abs(a - b);
    }

}
