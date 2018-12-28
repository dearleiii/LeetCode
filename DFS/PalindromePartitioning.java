class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        
        dfs(new ArrayList<String>(), s, 0, result);
        return result;
    }
    
    private void dfs(List<String> partition, String s, int startIndex, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(partition));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (!isPalindrone(subString)) {
                continue;
            }
            partition.add(subString);
            dfs(partition, s, i + 1, result);
            partition.remove(partition.size() - 1);
        }
    }
    
    private boolean isPalindrone(String s) {
        for (int i=0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
