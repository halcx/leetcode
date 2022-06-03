package Others.PalindromeNumber_9;

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//例如，121 是回文，而 123 不是。

//一开始因为刚做过回文子串的问题，想过转为string，然后用动态规划做
//但是其实完全没有必要
//只需要将数给反转了再判断就行，反转通过余数很好计算
public class Solution {
    public boolean isPalindrome(int x) {
        //负数和最后一位为0（且数不为0）的数一定不符合要求
        if(x<0||(x!=0&&x%10==0)){
            return false;
        }
        if (x<10){
            return true;
        }
        int origin = x;
        //反转数
        int revert = 0;
        while (x>0){
            revert = revert*10+x%10;
            x /= 10;
        }
        return revert==origin;
    }
}
