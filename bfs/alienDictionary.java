// Official solution ~ 35%
  // !Notes: 
    // 1. Divide into severeal functions
    // 2. Same as course schedul, construct graph first, record indegree 
    // 3. Priority queue: directly choose the smallest when there is same degree
    // 4. Language syntax: 
        (sb.length() != indegree.size()); // checking whether all nodes are polled -> whether valid graph
    
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        return topologicalSorting(graph);
    }
    
    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
            
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }
            }
        }
        
        // create edges : By lexicographically order 
        for (int i = 0; i < words.length-1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i+1].length()) {
                if (words[i].charAt(index) != words[i+1].charAt(index)) {
                    // put in as an edge 
                    //graph.put(words[i].charAt(index), graph.get(words[i].charAt(index)).add(words[i+1].charAt[index]));
                    graph.get(words[i].charAt(index)).add(words[i+1].charAt(index));
                    break; // finish checking this word -> next i iter
                }
                index++;
            }
        }
        
        return graph;
    }
    
    private Map<Character, Integer> getInDegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character u: graph.keySet()) {
            indegree.put(u, 0);
        }
        for (Character u: graph.keySet()) {
            for (Character v: graph.get(u)) {
                indegree.put(v, indegree.get(v) +1);
            }
        }
        return indegree;
    }
    
    private String topologicalSorting(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getInDegree(graph);
        Queue<Character> queue = new PriorityQueue<>();
        for (Character u: indegree.keySet()) {
            if (indegree.get(u) == 0) queue.offer(u);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character head = queue.poll();
            sb.append(head);
            for (Character neighbor: graph.get(head)) {
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if (indegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }
        
        if (sb.length() != indegree.size()) return "";
        return sb.toString();
    } 
}
