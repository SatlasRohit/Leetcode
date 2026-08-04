class FreqComparator implements Comparator<Map.Entry<Integer,Integer>>{
    public int compare(Map.Entry<Integer,Integer> a ,Map.Entry<Integer,Integer> b){
        return b.getValue() - a.getValue();
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i : nums){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }
        // O(N)
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>(new FreqComparator());
        int[] result = new int[k];

        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            maxHeap.offer(entry); // log(N)
        }
        // m times log(n);
        // so O(m log n)
        
        for(int i=0;i<k;i++){
            result[i] = maxHeap.poll().getKey();
}
        return result;
    }
}
// sp -> O(k)