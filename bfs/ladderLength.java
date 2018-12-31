

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;
            
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        
        queue.add(beginWord);
        set.add(beginWord);
        int step = 1;
        
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (String next: getNext(curr, wordList, set)) {
                    System.out.printf("%s ", next);
                    if (next.equals(endWord)) return step;    
                    
                    queue.offer(next);
                    set.add(next);
                }

            }
        }
        
        return 0;
    }
    
    private List<String> getNext(String word, List<String> wordList, HashSet<String> set) {
        List<String> res = new ArrayList<>();
        int diff = 0;
        
        for (int i = 0; i < wordList.size(); i++) {
            String compWord = wordList.get(i);
            for (int c = 0; c < word.length(); c++) {
                if (word.charAt(c) != compWord.charAt(c))
                    diff++;
            }
            if (diff == 1 && set.contains(compWord) == false) {
                set.add(compWord);
                res.add(compWord);
            }
            diff = 0;
        }

        return res;
    }
}
