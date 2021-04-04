class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(coins.length == 0)
            return -1;
        
        int[] dp = new int[amount+1];
        
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for(int i=1; i<=amount; ++i){
            for(int j=0; j<coins.length; ++j){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i-coins[j]]+1, dp[i]);
                }                
            }
        }
        
        if(dp[amount] == amount+1)
            dp[amount] = -1;
        
        return dp[amount]; 
        
//         int[][] dp = new int[coins.length][amount+1];
//         int min = Integer.MAX_VALUE;
        
//         // for(int i=0; i<=amount; ++i){
//         //     dp[0][i] = i;
//         //     if(i==amount)
//         //         min = Math.min(min, dp[0][i]);
//         // }
        
//         Arrays.sort(coins);
        
//         for(int i=0; i<coins.length; ++i){
//             for(int j=1; j<=amount; ++j){
//                 if(i == 0){
//                     if(j%coins[i] == 0)
//                         dp[i][j] = j/coins[i];
//                     else
//                         dp[i][j] = Integer.MAX_VALUE;
                        
//                     if(j==amount && dp[i][j] != 0)
//                         min = Math.min(min, dp[i][j]);
//                     continue;
//                 }
//                 if(coins[i]>j){
//                     // System.out.println(i+" "+j);
//                     dp[i][j] = dp[i-1][j];
//                 }
//                 else{
//                     int a = 1;
//                     if(dp[i][j-coins[i]] != Integer.MAX_VALUE)
//                         a = dp[i][j-coins[i]]+1;
//                     else
//                         a = Integer.MAX_VALUE;
//                     dp[i][j] = Math.min((dp[i-1][j]), a);
//                 }
//                 if(j==amount && dp[i][j] != 0)
//                     min = Math.min(min, dp[i][j]);
//             }
//         }
        
//         // for(int[] i: dp)
//         //     System.out.println(Arrays.toString(i));
        
//         min = min == Integer.MAX_VALUE? -1: min;
        
//         return min;
    }
}