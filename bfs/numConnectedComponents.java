// 19%
public int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) return n;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                bfsNode(graph, visited, i);
                cnt++;
            }
        }
        return cnt;
    }
    
    private void bfsNode(Map<Integer, Set<Integer>> graph, boolean[] visited, int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(pos);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int head = queue.poll();
                if (visited[head]) continue;
                visited[head] = true;
                for (int neighbor: graph.get(head)) {
                    if(!visited[neighbor]) queue.offer(neighbor);
                }
            }    
        }
    }
    
    
