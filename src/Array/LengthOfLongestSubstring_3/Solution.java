package Array.LengthOfLongestSubstring_3;

import java.util.HashSet;
import java.util.Set;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int rp = -1;
        int ans = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (rp+1<len&&!set.contains(s.charAt(rp+1))){
                rp++;
                set.add(s.charAt(rp));
            }
            ans = Math.max(ans,set.size());
        }
        return ans;
    }
}
