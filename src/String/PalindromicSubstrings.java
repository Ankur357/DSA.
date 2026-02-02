package String;

public class PalindromicSubstrings {

    // Method to count all palindromic substrings
    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes (center at i)
            count += findPalindrome(s, i, i);

            // Even-length palindromes (center between i and i+1)
            count += findPalindrome(s, i, i + 1);
        }
        return count;
    }

    // Helper method to expand around the center
    private static int findPalindrome(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aaa";
        String s3 = "abba";
        String s4 = "racecar";

        System.out.println("Input: \"" + s1 + "\" -> Palindromic substrings: "
                + countSubstrings(s1)); // 3

        System.out.println("Input: \"" + s2 + "\" -> Palindromic substrings: "
                + countSubstrings(s2)); // 6

        System.out.println("Input: \"" + s3 + "\" -> Palindromic substrings: "
                + countSubstrings(s3)); // 6

        System.out.println("Input: \"" + s4 + "\" -> Palindromic substrings: "
                + countSubstrings(s4)); // 10
    }
}

