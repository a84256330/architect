/**
 * 难度简单269收藏分享切换为英文关注反馈两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * @Classname 汉明距离
 * @Description TODO
 * @Date 2020/5/12 21:01
 * @Created by Ma
 */
public class 汉明距离 {
    public int hammingDistance(int x, int y) {

        int c = x^y;
        int count = 0;
        while(c!=0){
            ++count;
            c = c & (c-1);
        }
        return count;
    }
}
