class Solution {
    public String longestCommonPrefix(String[] strs) {
            Arrays.sort(strs);
            String First=strs[0];
            String Last=strs[strs.length-1];
            int min=Math.min(First.length(),Last.length());
            int i=0;
            while(i<min&&First.charAt(i)==Last.charAt(i))
            {
                i++;
            }
            return First.substring(0,i);
    }        
}