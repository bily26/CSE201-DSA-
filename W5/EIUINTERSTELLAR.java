import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class EIUINTERSTELLAR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        long[] arr = new long[elems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
        // queue will lower number will take first
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int count = 0;
        long totalBatt = 0;// over int

        for (int i = 0; i < arr.length; i++) {
            totalBatt += arr[i];
            if (arr[i] < 0) {
                queue.add(arr[i]);
            }
            // Case
            if (totalBatt < 0) {
                totalBatt -= queue.poll();
                count--;
            }
            count++;
        }

        System.out.println(count);
    }
}
