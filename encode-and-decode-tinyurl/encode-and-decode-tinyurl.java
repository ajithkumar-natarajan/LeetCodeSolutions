public class Codec {
    Map<Long, String> map;
    public Codec(){
        map = new HashMap<>();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] ch = longUrl.toCharArray();
        long value = 0;
        for(int i: ch){
            value += i;
        }
        
        map.put(value, longUrl);
        
        return String.valueOf(value);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Long.parseLong(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));