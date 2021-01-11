/**
 * @Author: mc
 * @DateTime: 2020/12/21 13:49
 * @Description: TODO
 */
public class a加c不等于2b {

    public static int[] makeNo(int size){
        if (1==size) {
            return new int[]{1};
        }

        // size
        // 一半长达标来
        // 7 : 4
        // 8 : 4
        int halfsize = (size+1)/2;
        int[] base = makeNo(halfsize);
        // base -> 等长奇数达标来
        // base -> 等长偶数达标来
        int[] ans = new int[size];
        int index = 0;
        for (; index < halfsize; index++) {
            ans[index] = base[index]*2+1;
        }
        for (int i = 0; index < size;index++, i++) {
            ans[index] = base[i] * 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(makeNo(7));
    }
}
