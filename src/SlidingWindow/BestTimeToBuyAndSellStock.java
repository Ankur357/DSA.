package SlidingWindow;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    // Method to calculate maximum profit
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println("Input: " + Arrays.toString(prices1));
        System.out.println("Max Profit: " + maxProfit(prices1)); // 5

        System.out.println("Input: " + Arrays.toString(prices2));
        System.out.println("Max Profit: " + maxProfit(prices2)); // 0
    }
}

