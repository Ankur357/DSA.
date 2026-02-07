package Sorting$Searching;

import java.util.Arrays;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (finishTime(piles, mid) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int finishTime(int[] piles, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += Math.ceil((double) pile / k);
        }

        return hours;
    }

    public static void main(String[] args) {
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;

        System.out.println("Piles: " + Arrays.toString(piles1) + ", h = " + h1);
        System.out.println("Min speed: " + minEatingSpeed(piles1, h1)); // 4

        System.out.println("\nPiles: " + Arrays.toString(piles2) + ", h = " + h2);
        System.out.println("Min speed: " + minEatingSpeed(piles2, h2)); // 30

        System.out.println("\nPiles: " + Arrays.toString(piles3) + ", h = " + h3);
        System.out.println("Min speed: " + minEatingSpeed(piles3, h3)); // 23
    }
}

