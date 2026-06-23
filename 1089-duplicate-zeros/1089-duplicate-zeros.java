class Solution {
    public void duplicateZeros(int[] arr) {
        int[] num = arr.clone();
        int i =0,j=0;
        while(j<arr.length){
            if(num[i] == 0){
                arr[j++] = num[i];
                if(j<arr.length) arr[j++] = num[i++];
                continue;
            }
            arr[j++] = num[i++];
        }
    }
}