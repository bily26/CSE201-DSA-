
import java.util.Scanner;

public class EIUPH014_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        //why n out the while loop cuz if n equals 0 so the loops will be ends
        int n = sc.nextInt();
        while (n != 0) {
            int[] arr = new int[n];
            boolean isEqual = true;
            int count = 0;

            // Case that if they have the all the numbers are the same at started.
            for (int idx = 0; idx < arr.length; idx++) {
                arr[idx] = sc.nextInt();
                // why idx > 0 ->  arr[idx-1] (idx=0) means idx at -1 dont existed.
                if (idx > 0 && arr[idx] != arr[idx - 1]) {
                    isEqual = false;
                }
            }
            // re-input n for new array size 
            n = sc.nextInt();
            if (isEqual) {
                sb.append(count + " \n");
                continue;
            }
            //Normal cases 
            // for loop start from 1-1000 cuz if the loop end
            for (int countLoops = 1; countLoops <= 1000; countLoops++) {
                isEqual = true;
                int temp = arr[0];

                for (int i = 0; i < arr.length; i++) {
                    // In case, out bound of the array
                    if (i == arr.length - 1) {
                        arr[arr.length - 1] = Math.abs(arr[arr.length - 1] - temp);
                    } else {
                        arr[i] = Math.abs(arr[i] - arr[i + 1]);
                    }
                    // same as the case before
                    if (i > 0 && arr[i] != arr[i - 1]) {
                        isEqual = false;
                    }
                }
                if (isEqual) {
                    sb.append(countLoops + "\n");
                    break;
                }
            }
            // cuz the for loop run from 1-1000 -> print -1
            if (!isEqual) {
                sb.append(-1 + "\n");
            }
        }
        System.out.println(sb);
    }
}
