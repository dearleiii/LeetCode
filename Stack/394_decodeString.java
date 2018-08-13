// All about Stack:   
    // https://www.callicoder.com/java-stack/
    
// Version1: myBroken
class Solution {
    public String decodeString(String s) {
        // Initializations
        Stack<String> encoded = new Stack<>();
        StringBuilder strToken= new StringBuilder("");
        StringBuilder cntToken= new StringBuilder("");
        char token;
        int pnt=0;
        
        while (pnt < s.length()) {
            token = s.charAt(pnt);
            if (Character.isDigit(token)) { // read til '['
                while (s.charAt(pnt++) != '[') {
                    cntToken.append(s.charAt(pnt));
                }
                // end of read k value, pnt at '['
                encoded.push(cntToken.toString());
                cntToken.setLength(0);
                System.out.println(encoded.peek());
            }
            else if (token == '[') {
                encoded.push(Character.toString(token));
                pnt++;
            }
            else if (Character.isLetter(token)) { // read till ']'
                while (s.charAt(pnt++) != ']') {
                    strToken.append(s.charAt(pnt));
                }
                encoded.push(strToken.toString());
                strToken.setLength(0);
                System.out.println(encoded.peek());
            }
            else { // read ']'
                popStack(encoded);
            }
            
        }
        
        // end of read, pop the stack to get all values
        while (!encoded.empty()) {
            strToken.insert(0, encoded.pop());
        }
        
        return strToken.toString();
    }
    
    private Stack<String> popStack(Stack<String> encoded) {
        StringBuilder token = new StringBuilder("");
        while (!encoded.empty() && encoded.peek() != "[") {
            token.insert(0, encoded.pop());
        }
        encoded.pop();
        int cnt = Integer.parseInt(encoded.pop());
        for (int i = 1; i < cnt; i++) {
            token.append(token);
        }
        encoded.push(token.toString());
        return encoded;
    }
}
