package Stack;

import java.util.Arrays;

public class CarFleet {

    static class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            double[][] cars = new double[n][2];

            for (int i = 0; i < n; i++) {
                cars[i][0] = position[i];
                cars[i][1] = (double) (target - position[i]) / speed[i];
            }

            Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

            int count = 0;
            double prevTime = 0;

            for (double[] car : cars) {
                if (car[1] > prevTime) {
                    count++;
                    prevTime = car[1];
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int target1 = 12;
        int[] position1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};

        int target2 = 10;
        int[] position2 = {3};
        int[] speed2 = {3};

        System.out.println("Car Fleets: " + sol.carFleet(target1, position1, speed1)); // 3
        System.out.println("Car Fleets: " + sol.carFleet(target2, position2, speed2)); // 1
    }
}
