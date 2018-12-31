class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || wordDict == null || wordDict.size() == 0) return result;
        
        boolean[][] isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                isWord[i][j] = wordDict.contains(word);
            }
        }
        
        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isWord[i][j] && possible[j + 1]) {
                    possible[i] = true;
                    break;
                }
            }
        }
        
        dfs(s, wordDict, new ArrayList<>(), 0, result, isWord, possible);
        return result;
    }
    
    private void dfs(String s, List<String> wordDict,
                     List<String> subStrings, int startIndex,
                    List<String> result,
                    boolean[][] isWord, boolean[] possible) {
        if (!possible[startIndex])
            return;
        
        // stop condition 
        if (startIndex == s.length()) {
            // construct the final string
            // result.add(subString);
            addString(subStrings, result);
            return;
        }

        // recursion
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i+1);
            if (isWord[startIndex][i] == false)
                continue;
            
            subStrings.add(subString);
            dfs(s, wordDict, subStrings, i+1, result, isWord, possible);
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
