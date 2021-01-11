package review;

/**
 * @Author: mc
 * @DateTime: 2021/1/6 18:24
 *  * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  *
 *  * 示例 1:
 *  *
 *  * 输入: "abcabcbb"
 *  * 输出: 3
 *  * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *  *
 *  *
 *  * 示例 2:
 *  *
 *  * 输入: "bbbbb"
 *  * 输出: 1
 *  * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *  *
 *  *
 *  * 示例 3:
 *  *
 *  * 输入: "pwwkew"
 *  * 输出: 3
 *  * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *  *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.equals("")) {
            return 0;
        }

        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }

        char[] str = s.toCharArray();

        int len = 0;
        int pre = -1;
        int ca = 0;

        for (int i = 0; i < str.length; i++) {

            pre = Math.max(pre,map[str[i]]);

            ca = i-pre;

            len=Math.max(len,ca);

            map[str[i]] = i;

        }
        return len;

    }
}
