package Dynamic.MaximumSubarray_53;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//子数组 是数组中的一个连续部分。

//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

//动态规划问题
//状态定义：
//dp[i]表示以第i个数结尾的最大连续子数组之和
//初始状态：
//dp[0] = nums[0]
//状态转移方程：
//dp[i] = max(dp[i-1]+nums[i],nums[i])
//返回：
//dp中最大的数

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length==1) return nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
