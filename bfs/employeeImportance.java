// Before solving the question, need to ask & make clear: what is importance score, does it include indirect sub-es? 

class Solution {
    // define emap as global variable, since called in both functions 
    Map<Integer, Employee> emap;
    
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}
