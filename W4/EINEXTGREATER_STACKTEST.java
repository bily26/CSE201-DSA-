import java.util.Scanner;
import java.util.Stack;

public class EINEXTGREATER_STACKTEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        int[] arr = new int[elems];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = new int[elems];

        Stack<Integer> stack = new Stack<>();
        for (int i = result.length - 1; i >= 0; i--) {
            // the stack.peek <= arr[i] (take the value just put in and compare to the
            // arr[i] not satisfied will pop out)
            while (!stack.empty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // emptyCase mean no value higher that it
            if (stack.empty()) {
                result[i] = -1;
            } else {
                // let the value in the result[i]
                result[i] = stack.peek();
            }
            // the value will store in and check
            stack.push(arr[i]);
        }

        for (int a : result) {
            sb.append(a + " ");
        }
        System.out.println(sb);
    }
}
