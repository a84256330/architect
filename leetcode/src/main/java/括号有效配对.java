import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: mc
 * @DateTime: 2020/12/15 21:04
 * @Description:
 * 1）任何一个左括号都能找到和其正确配对的右括号
 * 2）任何一个右括号都能找到和其正确配对的左括号
 *
 * 问题1：怎么判断一个括号字符串有效
 * 问题2：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
 */
public class 括号有效配对 {
    public boolean isPairing(String s){
        if (StringUtils.isEmpty(s)) {
            return false;
        }

        char[] chars = s.toCharArray();

        if(chars.length<2 || chars[0]==')'){
            return false;
        }
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='(') {
                count++;
            }else {
                count--;
            }
        }
        if (count==0) {
            return true;
        }
        return false;
    }

    public int pairing(String s){
        int count = 0;
        int need = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i]=='(') {
                count++;
            }else {
                if (count==0) {
                    need++;
                }else {
                    count--;
                }
            }
        }
        return count+need;
    }

    public static void main(String[] args) {
        String s ="()()()()";
        String s2 ="(((()()()())";
        括号有效配对 test = new 括号有效配对();
        System.out.println(test.isPairing(s));

        System.out.println(test.pairing(s));
        System.out.println(test.pairing(s2));
//        List<List<List<String>>> list = Arrays.asList(Arrays.asList(Arrays.asList("1","2","3"),Arrays.asList("4","5","6"),Arrays.asList("7","8","9"),Arrays.asList("10")));
//        List<String> collect = list.stream().flatMap(data -> data.stream().flatMap(data2->data2.stream())).collect(Collectors.toList());
//        System.out.println(collect);
    }
}
