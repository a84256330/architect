/**
 * @Classname t4
 * @Description TODO
 * @Date 2020/3/21 14:50
 * @Created by Ma
 */
public class t4 {
    public  boolean isPalindrome(String s){
        if (s.length()==0) {
            return true;
        }

        char[] sb = s.toCharArray();
        int l = 0,r = s.length()-1;

        while(l<r){
            if (!Character.isLetterOrDigit(sb[l])) {
                l++;
            }else if(!Character.isLetterOrDigit(sb[r])){
                r--;
            }else{
                if(Character.isLowerCase(sb[l]) !=
                        Character.isLowerCase(sb[r])){
                    return false;
                }
                r--;
                l++;
            }
        }
        return true;
    }
}
