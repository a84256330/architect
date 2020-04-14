/**
 * 难度简单21收藏分享切换为英文关注反馈一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 *
 *
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 *
 *
 * 提示：
 *
 *
 * 	0 <= n <= 100
 * @Classname 青蛙跳台阶问题
 * @Description TODO
 * @Date 2020/4/14 7:59
 * @Created by Ma
 */
public class 青蛙跳台阶问题 {
    public int numWays(int n) {
        int[] demo = new int[n + 1];
        return climbStairs(0,n,demo);
    }

    private int climbStairs(int i, int n, int[] demo) {
        if(i>n) return 0;
        if(i==n) return 1;
        if(demo[i]>0) return demo[i];

        demo[i] = climbStairs(i+1,n,demo)+climbStairs(i+2,n,demo);
        return demo[i];
    }
}
