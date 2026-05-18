class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        // If already at last index
        if(n == 1) {
            return 0;
        }

        // Store all indices for same values
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int s = 0; s < size; s++) {

                int curr = queue.poll();

                // Reached last index
                if(curr == n - 1) {
                    return steps;
                }

                // Jump to curr + 1
                if(curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // Jump to curr - 1
                if(curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }

                // Jump to same value indices
                if(map.containsKey(arr[curr])) {

                    for(int next : map.get(arr[curr])) {

                        if(!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }

                    // Important optimization
                    map.remove(arr[curr]);
                }
            }

            steps++;
        }

        return -1;
    }
}