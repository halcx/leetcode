package DfsAndBfs.Permutations_46;


import java.util.*;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

//一个典型的深度优先搜索问题
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(nums,len,0,path,used,res);
        return res;
    }

    /**
     *
     * @param nums  用来传递问题中的数组
     * @param len   传递数组长度，用来做边界判断
     * @param depth 传递目前搜索到的深度，用来做边界判断
     * @param path  传递已经加入搜索的数，也就是排序
     * @param used  传递各个数使用情况
     * @param res   传递结果
     */
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res){
        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                used[i] = true;
                path.addLast(nums[i]);
                dfs(nums,len,depth+1,path,used,res);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
