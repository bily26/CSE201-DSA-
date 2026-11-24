
import java.util.Scanner;

public class EIPICNIC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int elems = sc.nextInt();
        int[] arr = new int[elems];
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = sc.nextInt();
        }
        buildGroups(arr);
        int cars = calculateCar(buildGroups(arr));
        System.out.println(cars);

    }

    static int calculateCar(int[] groups) {
        int car = 0;

        if (groups[4] > 0) {
            car += groups[4];
        }
        if (groups[3] > 0) {
            car += groups[3];
        }
        if (groups[2] > 0) {
            car += groups[2] / 2;
        }
        if (groups[2] % 2 == 1) {
            car += 1;
        }
        if (groups[1] > 0) {
            groups[1] -= Math.min(groups[1], groups[3]);
            groups[1] -= Math.min(groups[1], 2 * (groups[2] % 2));
        }
        if (groups[1] > 0) {
            car += (int) Math.ceil(groups[1] / 4.0);
        }

        return car;
    }

    static int[] buildGroups(int[] arr) {
        int[] group = new int[5];// vi so gtri k dc qua 4 khong su dung 0 cua index
        for (int idx = 0; idx < arr.length; idx++) {
            group[arr[idx]]++;
        }
        return group;
    }
}
