class Solution {
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();      
      for(int idx=0;idx<s.length();idx++) {
            char ch = s.charAt(idx);
            if(isOpeningBracket(ch)) {
                stack.push(ch);
            }else if(!stack.isEmpty()) {
                char peekChar = stack.pop();
                char oppeningChar = getOpeningBracketForClosingBracket(ch);
                if(peekChar!=oppeningChar)
                    return false;
            }else {
                return false;
            }
      }
      return stack.isEmpty();  
    }

    private boolean isOpeningBracket(char ch) {
        return ch=='[' || ch == '{' || ch == '(';
    }

    private char getOpeningBracketForClosingBracket(char ch) {
        switch(ch) {
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
            default:
                return 'A';            
        }
    }
}
