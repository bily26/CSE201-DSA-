import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class EIPLATES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = sc.next();
        int sWSize = 9;
        // Avoiding duplicate
        Map<String, Integer> identical = new HashMap<>();

        // Sliding Window
        for (int j = 0; j <= input.length() - sWSize; j++) {
            String check = input.substring(j, j + sWSize);
            // Regex [Range]{n times} , [a-zA-Z] format able upperCase and lowerCase
            if (check.matches("[0-9]{2}[a-z A-Z]{2}[0-9]{5}")) {
                identical.put(check, j);
            }
        }

        // Using ArrayList to print
        List<String> formatted = new ArrayList<>(identical.keySet());
        // String.CASE_INSENSITIVE_ORDER sort theo ascii UpperCase value < lowerCase ->
        // lowerCase afterSort-> dung sau
        Collections.sort(formatted, String.CASE_INSENSITIVE_ORDER);
        for (String a : formatted) {
            sb.append(a + " ");
        }
        System.out.println(sb);
    }
}
