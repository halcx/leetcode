package Array.KthLargestElementinanArray215;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

import java.util.Arrays;
import java.util.PriorityQueue;

//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
public class Solution {
    //创建一个最小堆，然后构建最小堆，取堆顶元素即可
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            if(pq.size()<k){
                pq.offer(num);
            }else if(pq.peek()<num){
                pq.poll();
                pq.offer(num);
            }
        }
        int result = pq.poll();
        return result;
    }

    //基于快速排序的做法
    public int findKthLargest_quicksort(int[] nums, int k) {
        quickSort(nums,0, nums.length-1);
        return nums[nums.length-k];
    }

    //快速排序
    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i,j,x;
            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while(i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if(i < j)
                    a[i++] = a[j];
                while(i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if(i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i-1); /* 递归调用 */
            quickSort(a, i+1, r); /* 递归调用 */
        }
    }


    public static void main(String[] args) {
        int kthLargest = new Solution().findKthLargest_quicksort(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(kthLargest);
    }
}
