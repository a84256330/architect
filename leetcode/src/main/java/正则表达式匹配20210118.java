import java.util.Objects;

/**
 * @Author: mc
 * @DateTime: 2021/1/18 9:08
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class 正则表达式匹配20210118 {
    public boolean isMatch(String s, String p) {
        if (Objects.isNull(s) || Objects.isNull(p)){
            return Boolean.FALSE;
        }

        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        int[][] dp = new int[str.length + 1][ptr.length + 1];

        for (int si = 0; si <= str.length; si++) {
            for (int pi = 0; pi <= ptr.length; pi++) {
                dp[si][pi]=-1;
            }
        }

        return isValid(str,ptr) && process2(str,ptr,0,0,dp);
    }

    private boolean process2(char[] str, char[] pattern, int si, int pi, int[][] dp) {

        if (dp[si][pi] != -1) {
            return dp[si][pi] == 1;
        }

        // [si][pi] 第一次算

        // si越界了
        if(si==str.length){
            if (pi==pattern.length) {
                dp[si][pi]=1;
                return Boolean.TRUE;
            }

            if (pi+1<pattern.length && pattern[pi+1]=='*'){
               boolean ans = process2(str,pattern,si,pi+2,dp);
               dp[si][pi]=ans?1:0;
               return ans;
            }

            dp[si][pi]=0;
            return Boolean.FALSE;
        }

        // si没越界
        if(pi == pattern.length){
            boolean ans = si==str.length;
            dp[si][pi]=ans?1:0;
            return ans;
        }

        // si,pi没越界
        if(pi+1 >= pattern.length || pattern[pi+1] != '*'){
            boolean ans = ((str[si]==pattern[pi]) || (pattern[pi]=='.'))
                    && process2(str,pattern,si+1,pi+1,dp);

            dp[si][pi]=ans?1:0;
            return ans;
        }
        //  si 没越界 pi 没越界 pi+1 *
        if(pattern[pi]!='.' && pattern[pi] != str[si]){
            boolean ans = process2(str,pattern,si,pi+2,dp);
            dp[si][pi]=ans?1:0;
            return ans;
        }

        if(process2(str,pattern,si,pi+2,dp)){
            dp[si][pi]=1;
            return true;
        }

        while(si<str.length && ((str[si])==pattern[pi]) || (pattern[pi]=='.')){
            if(process2(str,pattern,si+1,pi+2,dp)){
                dp[si][pi]=1;
                return true;
            }
            si++;
        }

        dp[si][pi]=0;
        return false;

    }

    private boolean isValid(char[] str, char[] ptr) {
        for (char c : str) {
            if ('.'==c || '*'==c) {
                return Boolean.FALSE;
            }
        }

        for (int i = 0; i < ptr.length; i++) {
            if(ptr[i]=='*' && (i==0 || ptr[i-1]=='*')){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        正则表达式匹配20210118 a = new 正则表达式匹配20210118();
        System.out.println(a.isMatch("aa", "a*"));
    }
}
