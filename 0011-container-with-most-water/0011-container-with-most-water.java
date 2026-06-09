class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int max =0;
        while(left < right) {
            int minHeight = Math.min(height[left],height[right]);
            max= Math.max(minHeight*(right-left),max);
            while(left < right && height[left] <= minHeight) left++;
            while(left < right && height[right] <= minHeight) right--;
        }   
        return max;
    }
}