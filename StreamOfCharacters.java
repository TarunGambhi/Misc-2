//https://leetcode.com/problems/stream-of-characters
//TC : max length of word for query function
//SC : O(1)
class StreamChecker {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private void insert(String word){
        TrieNode curr = root;
        for(int i=word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    TrieNode root;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        this.root = new TrieNode();
        this.sb = new StringBuilder();
        for(String word : words){
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        if(root.children[letter-'a'] == null) return false;
        TrieNode curr = root;
        for(int i = sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if(curr.children[c-'a'] == null ) return false;
            curr = curr.children[c-'a'];
            if(curr.isEnd) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
