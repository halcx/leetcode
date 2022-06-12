package Dynamic.LongestIncreasingSubsequence_300;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。


//典型的动态规划问题
//状态定义：
//dp[i]:以i为结尾的最长上升子序列的长度
//初始状态：
//每个元素自己就是一个子序列：dp = 1
//状态转移:
//dp[i]与[0,i-1]当中每个dp[k]进行比较，如果比dp[k]大的话，那么至少就应该是dp[k]+1，找到所有dp[k]的最大值即可


import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int longest = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    longest = Math.max(longest,dp[j]+1);
                }
            }
            dp[i] = longest;
            ans = Math.max(longest,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }
}
