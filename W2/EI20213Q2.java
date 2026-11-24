
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EI20213Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elem = sc.nextInt();

        Map<Integer, Integer> freqNumb = new HashMap<>();
        for (int i = 0; i < elem; i++) {
            int number = sc.nextInt();
            // number is the key
            // map.getOrDefault(key,check value)
            // This case we check if it doesnt appeared means value=0
            // So if it appeared already so the value taken from key +1
            // else it will take the default mean 0 or user define

            freqNumb.put(number, freqNumb.getOrDefault(number, 0) + 1);
        }
        // Set is unique means no dupl
        // Increasing the times of that value which appeared
        // Using the arrayList to select the index
        // Using the map that have already to take the key(set/unique)
        // And value (the freq of the key)
        ArrayList<Integer> keys = new ArrayList<>(freqNumb.keySet());

        keys.sort((n1, n2) -> Integer.compare(n1, n2));
        for (int key : keys) {
            sb.append(key + " " + freqNumb.get(key) + "\n");
        }
        System.out.println(sb);
    }
}
