class Solution {
    public int shortestWay(String source, String target) {
        
        //let's start with basic subsequence finding.
        //Just continue the basic subsequence finding until you find all letters.
        //Time: O(length of S * length of T, we might have to go over the source for all letters of target)
        //Space: O(S + T, for all the letters of S and T)

        int s_pointer = 0;
        int t_pointer = 0;
        int t_len = target.length();
        int s_len = source.length();

        //first check if the letters for both the strings are same. 

        HashSet<Character> s_set = new HashSet<>();
        HashSet<Character> t_set = new HashSet<>();

        for(int i = 0; i < source.length(); i++){
            s_set.add(source.charAt(i));
        }

        for(int i = 0; i < target.length(); i++){
            t_set.add(target.charAt(i));
        }

        if(t_set.size() > s_set.size() || ((t_set.size() == s_set.size()) && !t_set.equals(s_set))){
            return -1;
        }
        
        int counter = 0;

        while( t_pointer < t_len){

            if(source.charAt(s_pointer) == target.charAt(t_pointer)){
                s_pointer ++;
                t_pointer ++;
            }

            else{
                s_pointer ++;
            }

            if(s_pointer > s_len - 1 && t_pointer < t_len){
                s_pointer = 0;
                counter ++;
            }
            
        }
        return counter + 1;

    }
}