class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                
                char ch = stack.pop();
                
                if(c == ')'){
                    if(ch == '(')
                        continue;
                    else
                        return false;
                }
                else if(c == ']'){
                    if(ch == '[')
                        continue;
                    else
                        return false;
                }
                else if(c == '}'){
                    if(ch == '{')
                        continue;
                    else
                        return false;
                }
            }
        }
        
        if(!stack.isEmpty())
            return false;
        
        return true;
    }
}