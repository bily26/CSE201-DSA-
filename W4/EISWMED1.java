import java.util.Scanner;

public class EISWMED1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phrase = sc.next();
        int conseBlackBloc = sc.nextInt();// SwindowSize
        int minOpe = 0;
        // Get words that separate by space;
        // trim() help remove the space from begin and end
        String[] words = phrase.trim().split("");

        int min = 0;
        for (int i = 0; i <= phrase.length() - conseBlackBloc; i++) {
            if (i == 0) {
                for (int j = 0; j < conseBlackBloc; j++) {
                    if (!"b".equalsIgnoreCase(words[j])) {
                        minOpe++;
                    }
                }
                if (minOpe > 0) {
                    min = minOpe;
                }
            } else {
                if (!"b".equalsIgnoreCase(words[conseBlackBloc + i - 1])) {
                    minOpe++;
                }
                if (!"b".equalsIgnoreCase(words[i - 1])) {
                    minOpe--;
                }
                if (min > 0) {
                    min = Math.min(min, minOpe);
                } else {
                    min = minOpe;
                }
            }
        }
        System.out.println(min);
    }
}
