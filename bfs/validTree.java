// Definition of a tree: 
  // 1. Graph nodes are all connected 
  // 2. No cycle 
  
// 2 Corner cases: 
  // 1. 4 [[0,1],[2,3]]: when there are 2 trees, not connected to each other 
  // 2. 1 []
  
// mine: 8.4%
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) return true;
        if (edges.length < n-1) return false;
        
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> degree = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            degree.put(i, 0);
            graph.put(i, new HashSet<Integer>());
        }
        // put the neighbors 
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree.put(edge[0], degree.get(edge[0])+1);
            degree.put(edge[1], degree.get(edge[1])+1);
        }
        
        // Start BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i: degree.keySet()) {
            if (degree.get(i) == 0) return false;
            if (degree.get(i) == 1) queue.offer(i);
        }
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                int head = queue.poll();
                cnt++;
                for (int neighbor: graph.get(head)) {
                    degree.put(neighbor, degree.get(neighbor)-1);
                    if (degree.get(neighbor) == 1) queue.offer(neighbor);
                }
            }
        }
        
        return cnt == n;
    }
}
