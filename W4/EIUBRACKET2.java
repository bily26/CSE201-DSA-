import java.util.Scanner;
import java.util.Stack;

public class EIUBRACKET2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            String phrase = sc.next();
            Stack storeSymb = new Stack<>();
            String[] words = phrase.trim().split("");
            Stack<String> stack = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < words.length; j++) {
                if (words[j].equals("(") || words[j].equals("{") || words[j].equals("[")) {
                    stack.push(words[j]);
                } else if (words[j].equals(")") || words[j].equals("}") || words[j].equals("]")) {
                    if (stack.empty()) {
                        flag = false;
                        break;
                    }
                    String open = stack.pop();
                    if (!checkBoth(open, words[j])) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!stack.empty()) {
                flag = false;
            }
            System.out.println(flag);
        }
    }

    static boolean checkBoth(String open, String close) {
        if (open.equals("(") && close.equals(")") || open.equals("[") && close.equals("]") || open.equals("{")
                && close.equals("}")) {
            return true;
        } else
            return false;
    }
}
