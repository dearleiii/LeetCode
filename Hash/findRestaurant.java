// 12.5% solution : list only, O(l1*l2) + some comparison

public String[] findRestaurant(String[] list1, String[] list2) {        
        int minVal = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            String name = list1[i];
            for (int j = 0; j < list2.length; j++) {
                if (name.equals(list2[j])) {
                    if (minVal > (i+j)) {
                        minVal = i+j;
                        res.clear();
                        res.add(name);
                    } else if (minVal == (i+j)) {
                        res.add(name);
                    }
                    break; // since no duplicates
                }
                // if not equal -> next one 
            }
        }
        
        
        String[] res_arr = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res_arr[i] = res.get(i);
        }
        return res_arr;
        
    }
    
    
    // 23.88% solution:
    public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    int minSum = Integer.MAX_VALUE;
    for (int i=0;i<list1.length;i++) map.put(list1[i], i);
    for (int i=0;i<list2.length;i++) {
        Integer j = map.get(list2[i]);
        if (j != null && i + j <= minSum) {
            if (i + j < minSum) { res.clear(); minSum = i+j; }
            res.add(list2[i]);
        }
    }
    return res.toArray(new String[res.size()]);
}
    
    // 91.76% solution: 
    Map<String, Integer> map1 = new HashMap<>();
        int i = 0;
        for (String s : list1) {
            map1.put(s, i);
            i++;
        }
        i = 0;
        int sum = list1.length + list2.length;
        String result = null;
        List<String> resultList = new ArrayList<>();
        for (String s : list2) {
            if (map1.containsKey(s)) {
                int newSum = i + map1.get(s);
                if (sum > newSum) {
                    sum = newSum;
                    result = s;
                } else if (newSum == sum) resultList.add(s);
            }
            i++;
        }
        resultList.add(result);
        String[] resultStr = new String[resultList.size()];
        for (int j = 0; j < resultList.size(); j++) {
            resultStr[j] = resultList.get(j);
        }
        return resultStr;
