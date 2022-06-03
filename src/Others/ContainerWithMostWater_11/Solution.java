package Others.ContainerWithMostWater_11;

//给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
//
//找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。
//
//说明：你不能倾斜容器。

//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。


//双指针法
//这个感觉确实有点难以想到，而且暂时也没有搞清楚是什么原理
//总的来说呢，就是尽量地让两个指针移动的时候往更大的方向去走
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while (left<right){
            res = Math.max(res,(right-left)*Math.min(height[right],height[left]));
            if(height[left]<=height[right]){
                left++;
            } else{
                right--;
            }
        }
        return res;
    }
}
