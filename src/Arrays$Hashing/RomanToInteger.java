package Arrays$Hashing;

public class RomanToInteger {

    // Helper method to get value of Roman numeral
    private static int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    // Method to convert Roman numeral to Integer
    public static int romanToInt(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));

            if (i + 1 < s.length() && curr < value(s.charAt(i + 1))) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }

        return sum;
    }

    // Main method to run and test
    public static void main(String[] args) {
        String s1 = "III";
        String s2 = "IV";
        String s3 = "IX";
        String s4 = "LVIII";
        String s5 = "MCMXCIV";

        System.out.println(s1 + " -> " + romanToInt(s1)); // 3
        System.out.println(s2 + " -> " + romanToInt(s2)); // 4
        System.out.println(s3 + " -> " + romanToInt(s3)); // 9
        System.out.println(s4 + " -> " + romanToInt(s4)); // 58
        System.out.println(s5 + " -> " + romanToInt(s5)); // 1994
    }
}
