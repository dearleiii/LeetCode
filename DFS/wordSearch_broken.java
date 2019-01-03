// 29 / 37 test cases passed.
// input: [["a","a"]]
// words: ["aaa"]


// expected: []
// output: ["aaa"]

// fix in main func. should mark the starting position as visited :
/*
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                visited[j][i] = true;
                dfs(board, i, j, String.valueOf(board[j][i]), visited, prefixes, resSet);
                visited[j][i] = false;
            }
        }
        */


class Solution {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        if (board == null || board.length == 0) return result;
        if (board[0] == null || board[0].length == 0) return result;
        
        Map<String, Boolean> prefixes = getPrefix(words);
        Set<String> resSet = new HashSet<>();
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                dfs(board, i, j, String.valueOf(board[j][i]), visited, prefixes, resSet);
            }
        }
        
        return new ArrayList<>(resSet);
    }
    
    private Map<String, Boolean> getPrefix(String[] words) {
        // find all possible prefix in words
        Map<String, Boolean> prefixes = new HashMap<>();
        
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i+1); // each of sub is a prefix
                if (!prefixes.containsKey(sub))
                    prefixes.put(sub, false);
            }
            prefixes.put(word, true);
        }
        
        return prefixes;
    }
    
    
    private void dfs(char[][] board, 
                    int x, int y, 
                    String word,
                    boolean[][] visited,
                    Map<String, Boolean> prefixes, 
                    Set<String> resSet) {
        // return condition 
        if (!prefixes.containsKey(word))
            return;
        if (prefixes.get(word)) 
            resSet.add(word);
        
        // recursion: when not a word, but a prefix of word
        int adjX, adjY;
        for (int i = 0; i < 4; i++) {
            adjX = x + dx[i];
            adjY = y + dy[i];
            // System.out.printf("recursion check %d, %d\n", adjX, adjY);
            
            if (!inBound(adjX, adjY, board[0].length, board.length))
                continue;
            if (visited[adjY][adjX])
                continue;
            
            visited[adjY][adjX] = true;
            dfs(board, adjX, adjY, word+board[adjY][adjX], visited, prefixes, resSet);
            visited[adjY][adjX] = false;
        }
        return;
    }
    
    private boolean inBound(int x, int y, int xLim, int yLim) {
        return (x >= 0 && y>= 0 && x < xLim && y < yLim);
    }
}
