class Solution {// time and space of O(rows*cols)
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0) return 0 ;
        
        int rows = A.length ;
        int cols = A.length ;
        // can reduce space to O(n) using and replacing value
        int[][] dp = new int[rows][cols];
        for(int col = 0 ; col< cols ; col++){
            dp[0][col] = A[0][col];
        }
        
        for(int i = 1; i< rows ; i++){
            for(int j = 0;j<cols ; j++ ){
                // if(j=0) in general way for checking index
                //     if(j = cols-1)
                //         else
                
                // Case 1:1st col j (j+1) last (j-1,j) other (j-1,j,j+1)
                dp[i][j] = A[i][j] + Math.min( Math.min(dp[i-1][Math.max(0,j-1)],dp[i-1][j]),
                                              dp[i-1][Math.min(j+1,cols - 1)]);
            }
        }
        int min = Integer.MAX_VALUE ;
        for(int x: dp[rows-1]){
            min = Math.min(x,min);
        }
        return min;
        
    }
}