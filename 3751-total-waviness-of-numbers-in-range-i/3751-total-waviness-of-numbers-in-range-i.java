class Solution {
    public int totalWaviness(int num1, int num2) {

        int waviness=0;
    
        for(int i = num1 ; i <= num2 ; i++){
            String str = String.valueOf(i);
            for(int j=1;j<(str.length()-1);j++){

                if(str.charAt(j-1) > str.charAt(j) && str.charAt(j+1) > str.charAt(j)){
                    waviness++;
                }
                if(str.charAt(j-1) < str.charAt(j) && str.charAt(j+1) < str.charAt(j)){
                    waviness++;
                }
            }
        }
        return waviness;
    }
}