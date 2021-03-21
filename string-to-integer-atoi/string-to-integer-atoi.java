class Solution {
    public int myAtoi(String s) {
        int ans = 0;
        boolean flag = false;
        boolean negate = false;
        
        if(s.length() == 0)
            return ans;
        
        for(char c: s.toCharArray()){
            if(Character.isLetter(c)){
                if(negate)
                    ans *= -1;
                return ans;
            }
            if(c == ' ' && !flag)
                continue;
            if((c == '+' || c == '-') && !flag){
                if(c == '-'){
                    negate = true;
                    flag = true;
                    continue;
                }
                flag = true;
                continue;
            }
            if(Character.isDigit(c)){
                if(Integer.MAX_VALUE/10 < ans || (Integer.MAX_VALUE/10 == ans && Integer.MAX_VALUE % 10 < (int)c-'0')){
                    if(negate)
                        return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                ans *= 10;
                ans += c-'0';
                flag = true;
                continue;
            }
            if(negate)
                ans *= -1;
            return ans;
        }
        
        if(negate)
            ans *= -1;
        
        return ans;
        
        
    }
}