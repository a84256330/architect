/**
 * @Classname t2
 * @Description TODO
 * @Date 2020/3/20 12:27
 * @Created by Ma
 */
public class t2 {

    public String longestCommonPrefix(String[] a) {
        if (a.length == 0) {
            return "";
        }

        String b = a[0];
        for (int i = 1; i < a.length; i++) {
            while (a[i].indexOf(b) != 0) {
                b = b.substring(0, b.length());
                if (b.isEmpty()) {
                    return "";
                }
            }
        }
        return b;
    }
}
