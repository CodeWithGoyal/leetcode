class Solution {
    public int trap(int[] height) {
        int rightMax[] = new int[height.length];
        rightMax[height.length -1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int leftMax = height[0];
        int ans = 0;
        for(int i = 1; i < height.length -1; i++){
            leftMax = Math.max(height[i], leftMax);
            ans += Math.min(leftMax, rightMax[i]) - height[i];
        }
        return ans;
    }
}