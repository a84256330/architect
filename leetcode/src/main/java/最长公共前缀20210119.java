import java.util.Objects;

/**
 * @Author: mc
 * @DateTime: 2021/1/19 8:47
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class 最长公共前缀20210119 {
    public static String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs)) {
            return "";
        }
        
        char[] str = strs[0].toCharArray();
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (String s : strs) {
            char[] temp = strs[index].toCharArray();
            if(index<s.length() && index<temp.length){
                if (str[index]!=temp[index]) {
                    break;
                }
                index++;
            }
            min = Math.min(index,min);
        }

        return strs[0].substring(0,min);

    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
