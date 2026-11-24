import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EIUBRACKET2_TESTQUEUE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String arr = sc.next();
            System.out.println(isBalanced(arr));
        }
    }

    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false; // closing without opening
                char top = stack.pop();
                if (!matches(top, c))
                    return false; // mismatched pair
            }
        }
        return stack.isEmpty(); // no unclosed brackets remaining
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

}
