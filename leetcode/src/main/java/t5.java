import java.util.Objects;

public class t5 {

    public static int paint(String str){
        if (Objects.isNull(str) || str.length()<2) {
            return 0;
        }

        char[] strs = str.toCharArray();
        int N = strs.length;
        int[] r = new int[N];

        r[N-1] = strs[N-1]=='G'?1:0;
        for (int i = N-2; i >= 0 ; i--) {
            r[i] = r[i+1]+(strs[i]=='G'?1:0);
        }

        int res = r[0];
        int l=0;
        for (int i = 0; i < N-1; i++) {
            l+=strs[i]=='R'?1:0;
            res = Math.min(res,l+r[i+1]);
        }
        res = Math.min(res,l+(strs[N-1]=='R'?1:0));
        return res;
    }
}
