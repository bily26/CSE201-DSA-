
import java.util.Arrays;
import java.util.Scanner;

public class EIUONCE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int elems = sc.nextInt();
            int[] arr = new int[elems];
            int[] duplNumbArr = new int[100000];
            for (int idx = 0; idx < elems; idx++) {
                arr[idx] = sc.nextInt();
                duplNumbArr[arr[idx]]++;
            }
            Arrays.sort(arr);
            for (int idx = 0; idx < elems; idx++) {
                if (duplNumbArr[arr[idx]] == 1) {
                    sb.append(arr[idx] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
