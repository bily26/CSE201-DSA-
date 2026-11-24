
import java.util.Arrays;
import java.util.Scanner;

public class EIKMAX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        int needFindHigh = sc.nextInt();
        int[] arr = new int[elems];
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < needFindHigh; i++) {
            sb.append(arr[arr.length - 1 - i] + " ");
        }
        System.out.println(sb);
    }
}
