import java.util.Scanner;

public class OilTank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        int C = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int minDisturbance = Integer.MAX_VALUE;
        int bestX = 0;

        // Try all possible initial oil X
        for (int X = 0; X <= C; X++) {

            int tank = X;
            int disturbance = 0;

            for (int i = 0; i < N; i++) {

                if (A[i] == 1) { // sell
                    if (tank < C) {
                        tank++;
                    } else {
                        disturbance++;
                    }
                } 
                else if (A[i] == -1) { // buy
                    if (tank > 0) {
                        tank--;
                    } else {
                        disturbance++;
                    }
                }
            }

            if (disturbance < minDisturbance) {
                minDisturbance = disturbance;
                bestX = X;
            }
        }

        // Output
        System.out.println(bestX);
    }
}
