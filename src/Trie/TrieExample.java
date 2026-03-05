package Trie;

public class TrieExample {

    // Definition for TrieNode.
    public static class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[26]; // 26 letters of the alphabet
        }

        // Check if a character exists in this node
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        // Get the child node corresponding to the character
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        // Insert a new node for the character
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        // Mark this node as the end of a word
        public void setEnd() {
            isEnd = true;
        }

        // Check if this node is the end of a word
        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        // Search for a word in the Trie
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        // Check if there's any word in the Trie that starts with the given prefix
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        // Search for the node corresponding to the last character of the prefix
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (node.containsKey(currentChar)) {
                    node = node.get(currentChar);
                } else {
                    return null;
                }
            }
            return node;
        }
    }

    public static void main(String[] args) {
        TrieExample solution = new TrieExample();
        Trie sol = solution.new Trie();

        // Insert words into the Trie
        sol.insert("apple");
        sol.insert("app");
        sol.insert("banana");

        // Test search for words
        System.out.println("Search 'apple': " + sol.search("apple"));    // true
        System.out.println("Search 'app': " + sol.search("app"));        // true
        System.out.println("Search 'banana': " + sol.search("banana"));  // true
        System.out.println("Search 'ban': " + sol.search("ban"));        // false

        // Test startsWith for prefixes
        System.out.println("Starts with 'app': " + sol.startsWith("app"));  // true
        System.out.println("Starts with 'ban': " + sol.startsWith("ban"));  // true
        System.out.println("Starts with 'bat': " + sol.startsWith("bat"));  // false
    }
}