class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];

        // best index stored at this node
        int index = -1;

        // smallest length for tie breaking
        int len = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    // Insert reversed word into trie
    private void insert(String word, int idx) {

        TrieNode node = root;
        int n = word.length();

        // update root answer
        if (n < node.len) {
            node.len = n;
            node.index = idx;
        }

        for (int i = n - 1; i >= 0; i--) {

            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            // store best answer at every node
            if (n < node.len) {
                node.len = n;
                node.index = idx;
            }
        }
    }

    // Find best matching suffix
    private int search(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // answer queries
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}