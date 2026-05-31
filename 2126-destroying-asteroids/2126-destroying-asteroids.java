class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;
        Arrays.sort(asteroids);
        long currmass=mass;
        for(int i : asteroids){
            if(currmass<i){
                return false;
            }
            currmass+=i;
        }
        return true;
    }
}