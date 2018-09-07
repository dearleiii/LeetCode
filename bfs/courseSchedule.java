// basic structure: BFS search of all the related courses 
  // notes! construct edges = new ArrayList<>() for all the related courses
  
  
 class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i =0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) queue.add(i); // find the course without any pre-req
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            int n = edges[course].size();
            for (int i = 0; i < n; i++) {
                int pointer = (int)edges[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0)  queue.offer(pointer);
            }
        }
        
        return count == numCourses;
    }
}
