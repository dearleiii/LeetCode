// 29/36 timem limit exceed 

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) return 0; 
        if (beginWord.equals(endWord)) return 1;
        
        // BFS
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        queue.offer(beginWord);
        set.add(beginWord);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            //System.out.println(queue);
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, wordList)) {
                    if (set.contains(nextWord)) continue;
                    if (nextWord.equals(endWord)) return length;
                    
                    set.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
    
    private String replace(String word, int index, char newChar) {
        StringBuilder newWord = new StringBuilder(word);
        newWord.setCharAt(index, newChar);
        return newWord.toString();
    }
    
    private ArrayList<String> getNextWords(String word, List<String> wordList) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) continue;
                String nextWord = replace(word, i, c);
                if (wordList.contains(nextWord)) nextWords.add(nextWord);
            }
        }
        
        return nextWords;
    }
}


// Fixed: 
    // need to check the original wordList -> whether exist duplicates
    // use HashSet to construct a new unique wordList 
