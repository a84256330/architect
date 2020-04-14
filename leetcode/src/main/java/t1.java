/**
 * @Classname t1
 * @Description TODO
 * @Date 2020/3/20 11:57
 * @Created by Ma
 */
public class t1 {
    public static String replaceSpace(String s){
        int count = s.length();
        System.out.println("字符串长度"+count);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char b = s.charAt(i);
            if (" ".equals(String.valueOf(b))) {
                sb.append("%20");
            }else{
                sb.append(b);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String a = "We are happy.";
        String c = replaceSpace(a);
        System.out.println(c);
    }

}
