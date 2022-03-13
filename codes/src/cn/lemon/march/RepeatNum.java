package cn.lemon.march;

import java.util.HashSet;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 */
public class RepeatNum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumSet(nums));
        System.out.println(findRepeatNumO(nums));
    }

    /**
     * 使用Java中的HashSet数据结构实现
     */
    public static int findRepeatNumSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 原地交换
     * 1.遍历数组nums，设索引初始值为i = 0:
     *      1.1 若 nums[i] = i：说明此数字已在对应索引位置，无需交换，因此跳过
     *      1.2 若 nums[nums[i]]=nums[i], 代表索引 nums[i]处和索引 i 处的元素值都为 nums[i], 即找到一组重复值，返回此值 nums[i]
     *      1.3 否则：交换索引为 i和 nums[i]的元素值，将此数字交换至对应索引位置
     * 2.若遍历完毕尚未返回，则返回 -1
     */
    public static int findRepeatNumO(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
