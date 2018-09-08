// My complicated & 1st broken: 14% || 107/100 -> passed
  // consider corner cases: org = [1], seq = [[1],[2,3],[3,2]] -> recons = [1] == org, but should return false 
  /*
  if (org.length != recons.size() || recons.size() != indegree.size()) return false;
        for (int i = 0; i < org.length; i++) {
            if (org[i] != recons.get(i)) return false;
        }
        return true;
        */
// note2: 
  // can put all functions in one main func;
  // no need to initialize Set<Integer> separately, it's initialized when new HashMap<>();
  
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = makeGraph(seqs);
        return uniqueOrg(org, graph);
    }
    
    private Map<Integer, Set<Integer>> makeGraph(List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < seqs.size(); i++) {
            for (int j = 0; j < seqs.get(i).size(); j++) {
                int item = seqs.get(i).get(j);
                if (!graph.containsKey(item)) graph.put(item, new HashSet<Integer>());
            }
        }
        // put in all the neighbors 
        for (int i = 0; i < seqs.size(); i++) {
            for (int j = 0; j < seqs.get(i).size()-1; j++) {
                int item = seqs.get(i).get(j);
                int neighbor = seqs.get(i).get(j+1);
                graph.get(item).add(neighbor);
            }
        }
        
        return graph;
    }
    
    private Map<Integer, Integer> getDegree(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();
        // initialize all degrees to 0
        for (int i: graph.keySet()) {
            indegree.put(i, 0);
        }
        for (int i: graph.keySet()) {
            for (int neighbor: graph.get(i)) {
                // neighbor degree +1
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }
    
    private boolean uniqueOrg(int[] org, Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegree = getDegree(graph);
        Queue<Integer> queue = new LinkedList<>();
        for (int i: indegree.keySet()) {
            if (indegree.get(i) == 0) {
                queue.offer(i); 
            }
        } 
        
        List<Integer> recons = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int head = queue.poll();
            recons.add(head);
            for (int neighbor: graph.get(head)) {
                indegree.put(neighbor, indegree.get(neighbor) -1);
                if (indegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }
        
        if (org.length != recons.size() || recons.size() != indegree.size()) return false;
        for (int i = 0; i < org.length; i++) {
            if (org[i] != recons.get(i)) return false;
        }
        return true;
    }
}

