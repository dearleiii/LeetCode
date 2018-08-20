// Before solving the question, need to ask & make clear: what is importance score, does it include indirect sub-es? 

// My code: runtime error for [[2, 5, []]] 
class Solution {
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap<>();
        int i = 1;
        for (Employee employee: employees) {
            emap.put(i++, employee);
        }
        return dfs(queryid);
    }
    
    private int dfs(int queryid) {
        Employee person = emap.get(queryid);
        int totImp = person.importance;
        for (int subord: person.subordinates) {
            totImp += dfs(subord);
        } 
        return totImp;
    }

}

// Standard solution 
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
