import java.util.*;

/**
 * @Author: mc
 * @DateTime: 2021/1/22 8:29
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 */
public class 电话号码的字母组合 {
//    public static char[][] phone = {
//            { 'a', 'b', 'c' }, // 2    0
//            { 'd', 'e', 'f' }, // 3    1
//            { 'g', 'h', 'i' }, // 4    2
//            { 'j', 'k', 'l' }, // 5    3
//            { 'm', 'n', 'o' }, // 6
//            { 'p', 'q', 'r', 's' }, // 7
//            { 't', 'u', 'v' },   // 8
//            { 'w', 'x', 'y', 'z' }, // 9
//    };
//
//    // "23"
//    public static List<String> letterCombinations(String digits) {
//        List<String> ans = new ArrayList<>();
//        if (digits == null || digits.length() == 0) {
//            return ans;
//        }
//        char[] str = digits.toCharArray();
//        char[] path = new char[str.length];
//        process(str, 0, path, ans);
//        return ans;
//    }

    // str = ['2','3']  3   3
    // str[....index-1]，按出的结果是什么都在path里
    // str[index...]  按完之后，有哪些组合，放入到ans里
//    public static void process(char[] str, int index, char[] path, List<String> ans) {
//        if (index == str.length) {
//            ans.add(String.valueOf(path));
//        } else {
//            char[] cands = phone[str[index] - '2'];
//            for (char cur : cands) {
//                path[index] = cur;
//                process(str, index + 1, path, ans);
//            }
//        }
//    }

//    public static void main(String[] args) {
//        System.out.println(letterCombinations("335"));
//    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        电话号码的字母组合 a = new 电话号码的字母组合();
        a.letterCombinations("23");
    }
}
