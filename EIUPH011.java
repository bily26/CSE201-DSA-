
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class EIUPH011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        // Linked is follow the input ordinal
        Set<Integer> set = new LinkedHashSet<>();
        for (int idx = 0; idx < elems; idx++) {
            set.add(sc.nextInt());
        }
        for (int integer : set) {
            System.out.print(integer + " ");
        }

        // Solution 1
        // int[] occurNumb = new int[100001];// n<=10^4
        // for (int idx = 0; idx < elems; idx++) {
        // if (occurNumb[arr[idx]] == 0) {//
        // sb.append(arr[idx] + " ");
        // }
        // occurNumb[arr[idx]]++;//
        // }
        // System.out.println(sb);

    }
}
