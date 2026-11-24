
import java.util.Scanner;

public class EIUPH014 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int countLoops = 0;
        boolean flag = false;
        boolean checkSame = false;
        while (!flag) {
            if (n == 0) {
                break;
            }
            if (countLoops > 1000) {
                countLoops = -1;
                break;
            }
            for (int idx = 1; idx < arr.length; idx++) {
                if (arr[idx - 1] != arr[idx]) {
                    checkSame = false;
                    break;
                } else {
                    checkSame = true;
                }
            }
            if (checkSame == true) {
                flag = true;
                break;
            } else {
                int firstNumb = arr[0];
                for (int idx = 1; idx < arr.length; idx++) {
                    int temp = arr[idx - 1];
                    int newNumb = Math.abs(arr[idx] - temp);
                    arr[idx - 1] = newNumb;
                }
                arr[arr.length - 1] = Math.abs(arr[arr.length - 1] - firstNumb);
            }
            countLoops++;
        }
        System.out.println(countLoops);
    }
}
