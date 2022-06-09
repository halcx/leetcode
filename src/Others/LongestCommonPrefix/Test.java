package Others.LongestCommonPrefix;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。

import java.nio.charset.StandardCharsets;

public class Test {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<2){
            return strs[0];
        }
        String substring = commonPrefix(strs[0],strs[1]);
        if (substring==""){
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            substring = commonPrefix(strs[i],substring);
        }
        return substring;
    }

    public String commonPrefix(String s1,String s2){
        int len = Math.min(s1.length(), s2.length());
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if(s1.charAt(i)==s2.charAt(i)){
                s.append(s1.charAt(i));
            }else {
                break;
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        String[] strs = new String[]{"flower","flow","flight"};
        String s = test.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
