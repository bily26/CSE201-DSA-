import java.util.Scanner;

public class EINEXTGREATEST {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int elems = sc.nextInt();
        int[] arr = new int[elems];
        // Storing new value Array
        int[] newArr = new int[elems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // according elem of the array do not have another elem so set last elem = -1
        int maxVal = arr[elems - 1];
        // set max from the origin arr cuz we go from arr.length--; so the last of the
        // origin arr elem is the highest value
        newArr[elems - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            // why arr[i+1]
            if (arr[i + 1] > maxVal) {
                maxVal = arr[i + 1];
            }
            // if no change or change it will store the value that highest after its numb
            newArr[i] = maxVal;
        }

        for (int i = 0; i < newArr.length; i++) {
            sb.append(newArr[i] + " ");
        }
        System.out.println(sb);
    }
}
