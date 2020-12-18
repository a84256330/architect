import org.apache.commons.lang3.StringUtils;

/**
 * @Author: mc
 * @DateTime: 2020/12/15 20:52
 * @Description:
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * ()()()()()()()
 * 0204
 */
public class 使括号有效的最少添加 {

    public int isPairing(String s){
        if (StringUtils.isEmpty(s)) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int ans = 0;
        int pre = 0;
        for (int i = 1; i < chars.length; i++) {

            if (')'==chars[i]) {
                pre = i - dp[i-1] - 1;
                if (pre>=0 && dp[pre]=='(') {
                    dp[i] = (2 + dp[i-1] + (pre>0?dp[pre-1]:0));
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
