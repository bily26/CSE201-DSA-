
import java.util.Scanner;

public class EIUTHU {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstPart = sc.nextLine();
        String secondPart = sc.nextLine();
        int fLength = firstPart.length();
        int sLength = secondPart.length();
        int sameChar = 0;
        int totalChar = 0;
        boolean flag = false;
        for (int i = 1; i <= Math.min(fLength, sLength); i++) {
            // substring(idx) -> take the string from idx to end the String (not include
            // char at idx)
            String f = firstPart.substring(fLength - i);
            // substring(0,idx) -> take from beginning to idx
            String s = secondPart.substring(0, i);
            // check 2 string
            if (f.equals(s)) {
                flag = true;
                sameChar = i;
                totalChar = fLength + sLength - sameChar;
            }
        }
        // Case that has no Char
        if (flag == false) {
            totalChar = fLength + sLength - sameChar;
        }
        System.out.println(totalChar);
    }
}
