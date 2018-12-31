class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();  // initialize the answer: type List
        if (digits.isEmpty()) return ans;    // check special case: if digits.isEmpty()

        // create a new mapping, special case handling: 0, 1 stay the same
	String[] mapping = new String[]{"0", "1", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
	ans.add("");

        for (int i=0; i < digits.length(); i++)	{
            // add the char. for each digits mapping
            // corresponding character string: mapping[x]
            int	x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
		String t = ans.remove();
                for (char s : mapping[x].toCharArray())	 // get each character in string[] mapping[x]
	            ans.add(t + s);
	    }
        }
	return ans;
    }

}

