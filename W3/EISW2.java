import java.util.Scanner;

public class EISW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elems = sc.nextInt();
        int sWSize = sc.nextInt();
        double[] arr = new double[elems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // Calculate
        double maxAvg = 0;
        double sum = 0;
        for (int i = 0; i <= arr.length - sWSize; i++) {

            if (i == 0) {
                for (int j = 0; j < sWSize; j++) {
                    sum += arr[j];
                }
                maxAvg = sum;
                continue;
            }
            sum += (arr[i + sWSize - 1] - arr[i - 1]);
            if (maxAvg < sum) {
                maxAvg = sum;
            }
        }
        maxAvg /= (double) sWSize * 100 / 100d;
        System.out.println(maxAvg);
    }

}
