import java.util.Scanner;

public class EIPFS3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        int[] arr = new int[elems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // Frefixing
        // This case at the beginning of the array add the 0 as the first elem help
        // avoid outbound the array
        int[] pfs = new int[elems + 1];
        for (int i = 0; i < pfs.length; i++) {
            if (i < 1) {
                pfs[i] = 0;
            } else {
                pfs[i] = pfs[i - 1] + arr[i - 1];
            }
        }
        int idx = 0;
        for (int i = 0; i < pfs.length; i++) {
            if (i == pfs.length - 1) {
                idx = -1;
                break;
            } else {
                int value = pfs[pfs.length - 1] - pfs[i];
                if (value == pfs[i + 1]) {
                    // why pfs is i+1 (index) but we take only take i
                    // the reason is we the prefixing we add 0 at the beginning means the pfs array
                    // is bigger than arr array by 1 elem and so just i+1-1=i
                    idx = i;
                    break;
                }
            }
        }
        System.out.println(idx);
    }
}
