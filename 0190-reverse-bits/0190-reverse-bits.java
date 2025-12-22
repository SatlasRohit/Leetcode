class Solution {
    public int reverseBits(int n) {
        int bit=32;
        int[] binary=new int[bit];
        int i=0;
        while(n>0){
            binary[i]=n%2;
            n=n/2;
            i++;
        }
        int num=0;
        for(int j=0;j<32;j++){
            num+=binary[j]*Math.pow(2,bit-1);
            bit--;
        }
        return num;
    }
}