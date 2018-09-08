// while consider put courses -> Array
  // keep a counter -: check whether it's possible to finish all courses 
    // if not -> return []
    
    
// convert List -> int[]
        if (cnt == numCourses) {
        int[] order_arr = new int[order.size()];
        for (int i = 0; i < order.size(); i++)
            order_arr[i] = order.get(i);
        return order_arr;
        } else { return new int[0]; }
    }
