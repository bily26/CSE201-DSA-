
import java.util.Arrays;
import java.util.Scanner;

public class EIPAGES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        int[] arr = new int[elems];
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = sc.nextInt();
        }
        // Sort ascending
        Arrays.sort(arr);
        // inf loop
        while (true) {
            // i is
            int i = 0;
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j < arr.length - 1 && distance(arr[j], arr[j + 1]) == 1) {
                    count++;
                } else {
                    count = j - i + 1;
                    if (count >= 3) {
                        count = 0;
                        sb.append(arr[i] + "-" + arr[j] + " ");
                    } else if (count == 2) {
                        count = 0;
                        sb.append(arr[j - 1] + " " + arr[j] + " ");
                    } else {
                        count = 0;
                        sb.append(arr[j] + " ");
                    }
                    i = j + 1;
                }
            }
            System.out.println(sb);
            break;
        }
    }

    static int distance(int a, int b) {
        int result = Math.abs(a - b);
        return result;
    }

}
