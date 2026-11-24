
import java.util.Scanner;

public class EIDORM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int AB = 2;
        int rooms = sc.nextInt();
        int[] roomCapa = new int[rooms];
        int[] currentInRoom = new int[rooms];
        for (int i = 0; i < rooms; i++) {
            roomCapa[i] = sc.nextInt();
            currentInRoom[i] = sc.nextInt();
        }
        int ableToJoin = 0;
        for (int idx = 0; idx < rooms; idx++) {
            if (currentInRoom[idx] - roomCapa[idx] >= 2) {
                ableToJoin++;
            }
        }
        System.out.println(ableToJoin);
    }
}
