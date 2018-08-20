// For each number, set up a new hash map, for recording distances 


class Solution {
    public int numberOfBoomerangs(int[][] p) {
        // Hashmap part 
        HashMap<Double, Integer> distanceMap = new HashMap<>();
        Double dist;
        int output = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (i == j) continue;
                // calculate distance of point i -> all other points, store
                dist = pairDistance(p, i, j);
                distanceMap.put(dist, distanceMap.getOrDefault(dist, 0) +1);
            }
            // math part
            for (Integer number: distanceMap.values()){
                output += number * (number-1);
            }
            distanceMap.clear();
        }
        
        return output;
    }
    
    private double pairDistance(int[][] p, int p1, int p2) {
        // res = srqt(pow(diff_x)+ pow(diff_y))
        double res = Math.pow(p[p1][0]-p[p2][0], 2) + Math.pow(p[p1][1]-p[p2][1], 2); 
        res = Math.sqrt(res);
        return res;
    }
}
