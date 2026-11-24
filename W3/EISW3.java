import java.util.Scanner;

public class EISW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phrase = sc.next();
        int defSizeSw = 3;
        int countNoReap = 0;
        for (int i = 0; i <= phrase.length() - defSizeSw; i++) {
            StringBuilder sb = new StringBuilder();
            String a = phrase.substring(i, i + defSizeSw);
            if (!(a.charAt(0) == (a.charAt(1))) &&
                    !(a.charAt(1) == (a.charAt(2))) &&
                    !(a.charAt(0) == (a.charAt(2)))) {
                countNoReap++;
            }
        }
        System.out.println(countNoReap);
    }
}
