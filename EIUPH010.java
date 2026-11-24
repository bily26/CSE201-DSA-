
import java.util.Scanner;

// The most common number
public class EIUPH010 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elems = sc.nextInt();
        // create 2 arrays
        // first is inputs
        //second is mark the frequen if its appears
        int[] listNumb = new int[elems];
        int[] freqNumb = new int[(int) Math.pow(10, 6)];

        //inputs with mark freq
        for (int i = 0; i < elems; i++) {
            listNumb[i] = sc.nextInt();
            freqNumb[listNumb[i]]++;
        }

        int highestFreq = 0; // need most repeats number
        int value = listNumb[0];// mark as the lowest number cuz if there are several numbers have the same freq so choose the lowest value

        // Notice: freqNumb[idx], idx also means the value that inputs
        for (int idx = 1; idx < freqNumb.length; idx++) {
            // comparation value that has the same freq
            if (freqNumb[idx] > highestFreq) {
                highestFreq = freqNumb[idx];
                value = idx;
            }
        }
        System.out.println(value + " " + highestFreq);
    }

}
