// No memorization version 
// time limit exceed version: 
// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || wordDict == null || wordDict.size() == 0) return result;
        
        boolean[] memo = new boolean[s.length()];
        boolean[] visited = new boolean[s.length()];
        
        dfs(s, wordDict, new ArrayList<>(), 0, result, memo, visited);
        return result;
    }
    
    private void dfs(String s, List<String> wordDict,
                     List<String> subStrings, int startIndex,
                    List<String> result,
                    boolean[] memo, boolean[] visited) {
        // stop condition 
        if (startIndex == s.length()) {
            // construct the final string
            // result.add(subString);
            addString(subStrings, result);
            return;
        }
        
        if (visited[startIndex]) {
            return 
        }
        // recursion
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i+1);
            if (!wordDict.contains(subString)) {
                continue;
            }
            subStrings.add(subString);
            dfs(s, wordDict, subStrings, i+1, result);
            subStrings.remove(subStrings.size() - 1);
        }
        return;
    }
    
    private void addString(List<String> subStrings, List<String> result) {
        StringBuilder sbdr = new StringBuilder("");
        for (int i = 0; i < subStrings.size(); i++) {
            sbdr.append(subStrings.get(i));
            sbdr.append(" ");
        }
        sbdr.deleteCharAt(sbdr.length() - 1);
        result.add(sbdr.toString());
        return;
    }
}
