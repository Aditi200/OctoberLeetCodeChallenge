class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
    int len = 0; // len of sequence
 
    for(int num: nums){
        int idx = Arrays.binarySearch(dp, 0, len, num);
 
        //if not found, return binarySearch return -insertPosition-1
        if(idx < 0){
            idx = - (idx + 1);
        }
 
        dp[idx] = num;
 
        //update len when insert position is at the end
        if(idx==len){
            len++;
        }
    }
 
    return len;
    }
}