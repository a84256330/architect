/**
 * @Classname 盛最多水的容器
 * @Description TODO
 * @Date 2020/5/12 20:06
 * @Created by Ma
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length-1;
        int ars = 0;
        while(l<r){
            int area = Math.min(height[l],height[r])*(r-1);
            ars = Math.max(ars,area);
            if(height[l]<=height[r]){
                ++l;
            }else {
                --r;
            }
        }
        return ars;
    }
}
