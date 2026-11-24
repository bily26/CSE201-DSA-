import java.util.Scanner;

public class EINEXTGREATER {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        int[] arr = new int[elems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] newArr = new int[elems];
        newArr[newArr.length - 1] = -1;

        for (int i = 0; i < newArr.length; i++) {
            int max = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    max = arr[j];
                    break;
                }
            }
            newArr[i] = max;
        }
        for (int i = 0; i < newArr.length; i++) {
            sb.append(newArr[i] + " ");
        }
        System.out.println(sb);
    }
}