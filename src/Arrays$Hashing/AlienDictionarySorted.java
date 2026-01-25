package Arrays$Hashing;

import java.util.HashMap;

public class AlienDictionarySorted {

    // Method to check if words are sorted according to alien dictionary
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Build character order mapping
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        // Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            for (int j = 0; j < w1.length(); j++) {
                // If second word ends before first
                if (j >= w2.length()) {
                    return false;
                }

                // Compare first differing character
                if (w1.charAt(j) != w2.charAt(j)) {
                    int c1 = map.get(w1.charAt(j));
                    int c2 = map.get(w2.charAt(j));

                    if (c1 > c2) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String[] words1 = {"hello", "leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";

        String[] words2 = {"word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";

        String[] words3 = {"apple", "app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Test Case 1: " + isAlienSorted(words1, order1)); // true
        System.out.println("Test Case 2: " + isAlienSorted(words2, order2)); // false
        System.out.println("Test Case 3: " + isAlienSorted(words3, order3)); // false
    }
}
