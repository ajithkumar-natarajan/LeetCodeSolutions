class Solution {
    public List<String> letterCombinations(String digits) {
        // char[] ch = new char[]
        if(digits.equals("") || digits.equals("0") || digits.equals(1))
            return new ArrayList<>();
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        // List<String> list = new ArrayList();
        Queue<String> q = new LinkedList<>();
        // list.add("");
        q.offer("");
        
        getStringCombination(digits, 0, map, q);
        
        return new ArrayList<>(q);
        
        
    }
    
    Queue<String> getStringCombination(String digits, int pos, Map<Character, char[]> map, Queue<String> q){
        if(pos < digits.length() && (digits.charAt(pos) != '0' || digits.charAt(pos) != '1' )){
        
            int length = q.size();

            for(int i=0; i<length; ++i){
                String str = q.poll();

                for(char c: map.get(digits.charAt(pos))){
                    q.offer(str+c);
                }
            }

            getStringCombination(digits, pos+1, map, q);
        }
        return q;
    }
}