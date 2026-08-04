class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) return nums;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (n1,n2) -> hash.get(n1) - hash.get(n2)
        );
        for(int n : hash.keySet()){
            queue.add(n);
            if(queue.size()>k) queue.poll();
        }
        int[] arr = new int[k];
        for(int i = k-1;i>=0;i--){
            arr[i]=queue.poll();
        }
        return arr;
    }
}
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // O(1) time
//         if (k == nums.length) {
//             return nums;
//         }
        
//         // 1. Build hash map: character and how often it appears
//         // O(N) time
//         Map<Integer, Integer> count = new HashMap();
//         for (int n: nums) {
//           count.put(n, count.getOrDefault(n, 0) + 1);
//         }

//         // init heap 'the less frequent element first'
//         Queue<Integer> heap = new PriorityQueue<>(
//             (n1, n2) -> count.get(n1) - count.get(n2));

//         // 2. Keep k top frequent elements in the heap
//         // O(N log k) < O(N log N) time
//         for (int n: count.keySet()) {
//           heap.add(n);
//           if (heap.size() > k) heap.poll();    
//         }

//         // 3. Build an output array
//         // O(k log k) time
//         int[] top = new int[k];
//         for(int i = k - 1; i >= 0; --i) {
//             top[i] = heap.poll();
//         }
//         return top;
//     }
// }