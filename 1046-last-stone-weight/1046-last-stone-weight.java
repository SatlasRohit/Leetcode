public class Solution {
    public int lastStoneWeight(int[] arr){
        MaxHeap maxHeap = new MaxHeap();
        for(int i=0; i<arr.length;i ++){
            maxHeap.add(arr[i]);
        }
        while(maxHeap.getSize()>1){
            int max = maxHeap.extractMax();
            int secondMax = maxHeap.extractMax();
            int newWeight = max-secondMax;
            if(newWeight!=0){
                maxHeap.add(newWeight);
            }
        }
        if(maxHeap.getSize()==0){
            return 0;
        }
    return maxHeap.getRootElement();
    }

private class MaxHeap {
    private int capacity = 5;
    private int[] array = new int[capacity];
    private int size=0;

    public void add(int x){
        if(size==capacity){
            resize();
        }
        array[size]=x;
        size++;
        heapifyUp(size-1);
    }

    public int extractMax(){
        int max = array[0];
        array[0] = array[size-1];
        size--;
        heapifyDown(0);
        return max;
    }

    public int getSize(){
        return size;
    }

    public int getRootElement(){
        return array[0];
    }

    // O(n)
    private void resize(){
        capacity = capacity + capacity/2;
        int[] newArray = new int[capacity];
        for(int i=0; i<size; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // O(log n)
    private void heapifyUp(int index){
        while(true){
            int parent = (index-1)/2;
            if(array[parent]<array[index]){
                swap(parent,index);
                index=parent;
            }
            else{
                break;
            }
        }
    }

    private void swap(int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // O(log n)
    private void heapifyDown(int parent){
        while(true){
            int left = 2*parent+1;
            int right = 2*parent+2;
            
            int maxIndex = -1;
            if(right<size && array[right]>array[left] && array[right]>array[parent]){
                maxIndex = right;
            }
            else if(left<size && array[left]>=array[right] && array[left]>array[parent]){
                maxIndex = left;
            }
            if(maxIndex==-1)
                break;
            else{
                swap(maxIndex,parent);
                parent = maxIndex;
            }
        }
    }
}

}