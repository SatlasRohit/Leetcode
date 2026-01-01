class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            arr.add(new ArrayList<>());
            arr.get(i).add(1);
            for(int j=1;j<(i+1);j++){
                if(j==i){
                    arr.get(i).add(1);
                    break;
                }
                arr.get(i).add(arr.get(i-1).get(j-1)+arr.get(i-1).get(j));
            }
        }
        return arr;
    }
}