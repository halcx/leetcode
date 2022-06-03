package Array.TwoSum_1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
