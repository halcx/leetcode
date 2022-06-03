package Dynamic.LongestPalindromicSubstring_5;

//给你一个字符串 s，找到 s 中最长的回文子串。
//状态：dp[i][j] => 从i到j为回文子串
//初始状态：
//1. i==j 的时候一定是回文子串
//2. i+1 == j 并且 s[i]==s[j]的时候一定是回文子串
//状态转移方程：
//1. 如果dp[i+1][j-1]==true,并且s[i]==s[j],则dp[i][j] = true

//返回，找到j-i的最大值
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j+1][i-1]&&s.charAt(i)==s.charAt(j)){
                    dp[j][i] = true;
                }
            }
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j][i]&&right-left<i-j){
                    right = i;
                    left = j;
                }
            }
        }
        return s.substring(left,right+1);
    }
}
