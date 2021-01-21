package review;

/**
 * @Author: mc
 * @DateTime: 2021/1/12 20:50
 * @Description: TODO
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {

        int max = 0;

        int l = 0;

        int r = height.length-1;

        while (l<r){

            max =Math.max(max,Math.min(height[l],height[r]) * (r-l));

            if (height[l]<height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
