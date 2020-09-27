class Solution {// Time of O(M+N) space of O(M)
    public int deleteAndEarn(int[] nums) {
        // Base case
        if(nums == null || nums.length ==0)
            return 0;
        int max = Integer.MIN_VALUE ;
        for(int x: nums){//O(N)
            max = Math.max(x,max);
        }
        int[] count = new int[max+1];// O(M)
        for(int x : nums){
            count[x]++ ;
        }
        int[][] dp = new int[max+1] [2];
        dp[0][0] = 0 ;
        dp[0][1] = 0 ;
        for (int i = 1; i<=max ; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + count[i]*i;
        }
        return Math.max(dp[max][0],dp[max][1]);
    }
}