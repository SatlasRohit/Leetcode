// class Freecomparator implements Comparator<Map.Entry<Integer,Integer>>{
//     public int compare(Map.Entry<Integer,Integer> a , Map.Entry<Integer,Integer> b){
//         return b.getValue() - a.getValue();
//     }
// }
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hs = new HashMap<>();
        for(int i : nums){
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pr = new PriorityQueue<>(
            (a,b)-> b.getValue() - a.getValue()
        );
        int[] result = new int[k];
        for(Map.Entry<Integer,Integer> map : hs.entrySet()){
            pr.offer(map);
        }
        for(int i=0;i<k;i++){
            result[i] = pr.poll().getKey();
        }
        return result;
    }
}
// sp -> O(k)