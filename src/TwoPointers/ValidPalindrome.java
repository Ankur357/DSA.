package TwoPointers;

public class ValidPalindrome {

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        String s4 = "0P";

        System.out.println("\"" + s1 + "\" -> " + isPalindrome(s1)); // true
        System.out.println("\"" + s2 + "\" -> " + isPalindrome(s2)); // false
        System.out.println("\"" + s3 + "\" -> " + isPalindrome(s3)); // true
        System.out.println("\"" + s4 + "\" -> " + isPalindrome(s4)); // false
    }
}

