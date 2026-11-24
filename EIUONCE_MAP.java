
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EIUONCE_MAP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int idx = 0; idx < n; idx++) {
                int elem = sc.nextInt();
                // input key trc sau do map.getOrDefault(value)
                map.put(elem, map.getOrDefault(elem, 0) + 1);

            }
            // Phai thong qua arraylist moi in ra dc
            ArrayList<Integer> lists = new ArrayList<>(map.keySet());
            // sort by using lambda expression
            // Integer.conoare means compare s1 and s2 default the output s1 will the small
            // and s2 the larger
            lists.sort((s1, s2) -> Integer.compare(s1, s2));
            for (int k : lists) {
                if (map.get(k) == 1) {
                    sb.append(k + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
