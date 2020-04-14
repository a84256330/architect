import java.util.HashSet;

/**
 * @Classname t3
 * @Description TODO
 * @Date 2020/3/21 10:29
 * @Created by Ma
 */
public class t3 {
    public int longestPalindrome(String s) {
        if (s.length()<=0) {
            return 0;
        }

        char[] a = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (!set.contains(a[i])) {
                set.add(a[i]);
            }else{
                set.remove(a[i]);
                count++;
            }
        }
       return set.isEmpty()? count*2:count*2+1;

    }
}
