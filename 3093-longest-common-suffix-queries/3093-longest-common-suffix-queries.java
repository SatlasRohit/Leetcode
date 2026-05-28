class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];

        int len = Integer.MAX_VALUE;
        int idx = 0;
    }

    TrieNode root = new TrieNode();

    void insert(String s, int index) {

        TrieNode node = root;

        int n = s.length();

        // update root
        if (n < node.len) {
            node.len = n;
            node.idx = index;
        }

        for (int i = n - 1; i >= 0; --i) {

            int c = s.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            if (n < node.len) {
                node.len = n;
                node.idx = index;
            }
        }
    }

    int search(String s) {

        TrieNode node = root;

        int ans = node.idx;

        for (int i = s.length() - 1; i >= 0; --i) {

            int c = s.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];

            ans = node.idx;
        }

        return ans;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        for (int i = 0; i < wordsContainer.length; ++i) {
            insert(wordsContainer[i], i);
        }

        int[] res = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; ++i) {
            res[i] = search(wordsQuery[i]);
        }

        return res;
    }
}