import java.util.*;

public class EINEXTGREATER_STACK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] a2 = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                a2[i] = -1;
            } else {
                a2[i] = stack.peek();
            }
            stack.push(a[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(a2[i]).append(" ");
        }
        System.out.print(sb);
    }
}
