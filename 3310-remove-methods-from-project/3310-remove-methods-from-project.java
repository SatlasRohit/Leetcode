class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] e : invocations) {
            adj[e[0]].add(e[1]);
        }
        
        boolean[] suspicious = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        suspicious[k] = true;
        
        while (!q.isEmpty()) {
            int u = q.poll();
            
            for (int v : adj[u]) {
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    q.offer(v);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                for (int v : adj[i]) {
                    if (suspicious[v]) {
                        List<Integer> ans = new ArrayList<>();
                        for (int j = 0; j < n; j++) {
                            ans.add(j);
                        }
                        return ans;
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }
        
        return ans;
    }
}