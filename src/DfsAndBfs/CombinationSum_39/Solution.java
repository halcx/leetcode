package DfsAndBfs.CombinationSum_39;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 */

/**
 * 既然是可以重复使用数，那我们在dfs的时候就要分为跳过和不跳过这两种方式来判断
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res,path,target,candidates,0);
        return res;
    }

    /**
     *
     * @param res
     * @param path
     * @param target
     * @param candidates
     * @param k
     */
    public void dfs(List<List<Integer>> res, List<Integer> path,int target,int[] candidates,int k){
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(k==candidates.length){
            return;
        }
        //跳过这个数
        dfs(res,path,target,candidates,k+1);
        //不跳过这个数，但是不跳过是有一个前提的，就是加上这个数还不够target
        if (target-candidates[k]>=0) {
            path.add(candidates[k]);
            dfs(res,path,target-candidates[k],candidates,k);
            path.remove(path.size()-1);
        }
    }


//    输入：candidates = [2,3,6,7], target = 7
//    输出：[[2,2,3],[7]]
    public static void main(String[] args) {
        int[] ints = {2, 3, 6, 7};
        List<List<Integer>> lists = new Solution().combinationSum(ints, 7);
        System.out.println(lists);
    }
}
