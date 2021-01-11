/**
 * @Author: mc
 * @DateTime: 2021/1/11 9:19
 * @Description: TODO
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *  
 *
 * 注意：
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 */
public class 整数反转 {

    public int reverse(int x) {
        Boolean bool = ((x >>> 31) & 1)==1;

        x = bool?x:-x;

        int res = 0;
        int m = Integer.MIN_VALUE/10;
        int n = Integer.MIN_VALUE%10;

        while (x!=0){
            if(res<m || (res==m && (x%10)<n)){
                return 0;
            }
            res = res * 10 + x%10;
            x /= 10;

        }

        return bool?res:Math.abs(res);
    }

}
