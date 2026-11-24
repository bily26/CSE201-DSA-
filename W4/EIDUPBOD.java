import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EIDUPBOD {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // xài sc.nextInt khi nhập sẽ lấy giá trị sau đó chừa lại \n
        // nên xài sc.nextLine để xuống dòng dưới mới lấy được data
        int t = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < t; i++) {
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            String formatOfDate = String.format("%04d/%02d/%02d", year, month, day);
            freq.put(formatOfDate, freq.getOrDefault(formatOfDate, 0) + 1);
        }

        ArrayList<String> frqPerDates = new ArrayList<>(freq.keySet());
        Collections.sort(frqPerDates);

        for (String frqPerDate : frqPerDates) {
            String day = frqPerDate.substring(8, 10);
            String month = frqPerDate.substring(5, 7);
            String year = frqPerDate.substring(0, 4);
            System.out.println(day + "/" + month + "/" + year + " " + freq.get(frqPerDate));
        }

    }
}
