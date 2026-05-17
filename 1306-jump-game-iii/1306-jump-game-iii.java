class Solution {
    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }

    public boolean dfs(int[] arr, int index, boolean[] visited) {

        // Out of bounds
        if(index < 0 || index >= arr.length) {
            return false;
        }

        // Already visited
        if(visited[index]) {
            return false;
        }

        // Found 0
        if(arr[index] == 0) {
            return true;
        }

        visited[index] = true;

        int forward = index + arr[index];
        int backward = index - arr[index];

        return dfs(arr, forward, visited) ||
               dfs(arr, backward, visited);
    }
}