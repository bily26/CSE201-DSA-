import java.util.Scanner;

public class EIRAINTRAP_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elems = sc.nextInt();
        long[] waterLevel = new long[elems];
        for (int i = 0; i < waterLevel.length; i++) {
            waterLevel[i] = sc.nextInt();
        }

        long[] highestLeft = highestLeft(waterLevel);

        long[] hightRight = highestRight(waterLevel);

        // why using 2 array to lookup the highest 2 side
        // after that we can use min to intersect 2 side and get the minimum and use it
        // minus the water level will have the number of water blocks
        long totalWaterBloc = 0;// could be over integer
        for (int i = 0; i < waterLevel.length; i++) {
            totalWaterBloc += Math.min(highestLeft[i], hightRight[i]) - waterLevel[i];
        }
        System.out.println(totalWaterBloc);
    }

    static long[] highestLeft(long[] waterLevel) {
        long max = waterLevel[0];
        long[] highestLeft = new long[waterLevel.length];
        for (int i = 0; i < highestLeft.length; i++) {
            if (i == 0) {
                highestLeft[0] = waterLevel[0];
            } else {
                if (max <= waterLevel[i]) {
                    max = waterLevel[i];
                    highestLeft[i] = waterLevel[i];
                } else {
                    highestLeft[i] = max;
                }
            }
        }
        return highestLeft;
    }

    static long[] highestRight(long[] waterLevel) {
        long max = waterLevel[waterLevel.length - 1];
        long[] highestRight = new long[waterLevel.length];
        for (int i = highestRight.length - 1; i >= 0; i--) {
            if (i == highestRight.length - 1) {
                highestRight[highestRight.length - 1] = waterLevel[waterLevel.length - 1];
            } else {
                if (max <= waterLevel[i]) {
                    max = waterLevel[i];
                    highestRight[i] = waterLevel[i];
                } else {
                    highestRight[i] = max;
                }
            }
        }
        return highestRight;
    }
}
