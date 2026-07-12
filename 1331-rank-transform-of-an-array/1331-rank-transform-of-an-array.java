class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] num = new int[n];
        for(int i=0;i<n;i++) num[i]=arr[i];
        Arrays.sort(num);
        int rank = 1;
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int x : num){
            if(!hs.containsKey(x)) hs.put(x,rank++);
        }
        for(int i=0;i<n;i++){
            num[i] = hs.get(arr[i]);
        }
        return num;
    }
}