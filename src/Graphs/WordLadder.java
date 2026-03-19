package Graphs;

import java.util.*;

public class WordLadder {

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);
            if (!set.contains(endWord)) return 0;

            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            int change = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String word = queue.poll();

                    if (word.equals(endWord)) return change;

                    for (int j = 0; j < word.length(); j++) {
                        char[] arr = word.toCharArray();
                        for (char k = 'a'; k <= 'z'; k++) {
                            arr[j] = k;
                            String str = new String(arr);
                            if (set.contains(str) && !visited.contains(str)) {
                                queue.add(str);
                                visited.add(str);
                            }
                        }
                    }
                }
                change++;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = sol.ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation length: " + result); // Output: 5
    }
}
