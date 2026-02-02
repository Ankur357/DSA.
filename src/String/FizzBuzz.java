package String;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    // Method to generate the FizzBuzz list
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int n1 = 15;
        int n2 = 5;

        System.out.println("FizzBuzz up to " + n1 + ":");
        System.out.println(fizzBuzz(n1));

        System.out.println("FizzBuzz up to " + n2 + ":");
        System.out.println(fizzBuzz(n2));
    }
}

