class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int farthest = 0;

        while (!q.isEmpty()) {

            int current = q.poll();

            // Possible jump range
            int start = Math.max(current + minJump, farthest + 1);
            int end = Math.min(current + maxJump, n - 1);

            for (int next = start; next <= end; next++) {

                if (s.charAt(next) == '0' && !visited[next]) {

                    if (next == n - 1)
                        return true;

                    visited[next] = true;
                    q.offer(next);
                }
            }

            farthest = end;
        }

        return n == 1;
    }
}