package Arrays$Hashing;

public class ValidAnagram {

    // Method to check if two strings are anagrams
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int count : arr) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        System.out.println("Test Case 1: " + isAnagram(s1, t1)); // true
        System.out.println("Test Case 2: " + isAnagram(s2, t2)); // false
    }
}

