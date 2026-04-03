class Solution {

    public int isSubsetSum(int arr[], int sum) {
        
        int n = arr.length;
        int mod = 1000000007;
        
        int t[][] = new int[n+1][sum+1];
        
        // Initialization
        for(int i = 0; i < n+1; i++){
            t[i][0] = 1;
        }
        
        for(int j = 1; j < sum+1; j++){
            t[0][j] = 0;
        }
        
        // DP Logic
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < sum+1; j++){
                
                if(arr[i-1] <= j){
                    t[i][j] = (t[i-1][j-arr[i-1]] + t[i-1][j]) % mod;
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for(int i=0;i<nums.length ;i++){
            sum += nums[i];
        }

        if((target + sum) % 2 != 0) return 0;
        if(sum < Math.abs(target)) return 0;
        int s1 = (target + sum )/2 ;
        return isSubsetSum(nums,  s1);
    }
}