import java.util.Arrays;
import java.util.Scanner;

public class EIUGIFTS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[elems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // Sort
        Arrays.sort(arr);
        // Case L= start and R= end run until L==R
        int left = 0;
        int right = arr.length - 1;
        // Require from topic
        int maxSum = 0;
        int minDif = 0;
        boolean isAbleTarget = false;
        while (left < right) {
            // value is the numb compare to the target that we able to pay
            // Max sum is the highest cost that able to pay
            // Min dif is the cost between 2 gifts
            int value = arr[left] + arr[right];
            if (value <= target) {
                isAbleTarget = true;
                if (value >= maxSum) {
                    maxSum = value;
                    minDif = arr[right] - arr[left];
                }
                left++;
            } else {
                right--;
            }
        }
        // !=false will not join in
        if (!isAbleTarget) {
            maxSum = -1;
            minDif = -1;
        }
        System.out.println(maxSum + " " + minDif);
    }
}
