package cn.org.shelly.leetcode.hot100.hard;
/**
 * ✔ 缺失的第一个正数
 * 原地hash
 * @author shelly
 * @date 2025/7/15
 */
public class Problem_41 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for(int i = 0;i<nums.length;i++){
                if(nums[i] -1 == i || nums[i] <= 0 || nums[i] > nums.length) continue;
                int toIndex = nums[i] - 1;
                int fromIndex = i;
                while(nums[fromIndex] - 1 != fromIndex){
                    if(nums[toIndex] -1 == toIndex) break;
                    int tmp = nums[toIndex];
                    nums[toIndex] = nums[fromIndex];
                    nums[fromIndex] = tmp;
                    if(nums[fromIndex] <= 0 || nums[fromIndex] > nums.length) break;
                    toIndex = tmp - 1;
                }
            }
            for(int i = 0;i<nums.length;i++){
                if(nums[i] -1 != i) return i + 1;
            }
            return nums.length + 1;
        }
    }
}
/**
 * 数组的大小为n，很容易得出，最终答案一定为1到n+1范围内的整数，
 * 也就是范围总共为n，刚好和数组大小相同，可以合理利用，因为只有1到n的数据会影响我们这个题的答案，
 * 而数组的下标是0到n-1，刚好也是n的长度，所以对于每一个1到n数值x，把它映射到x-1下标的位置，
 * 最终全部映射之后，遍历一遍，如果哪个位置上的值不符合减一，那就说明，一定是缺失的那个值，导致了没有正确映射.
 *
 * 部分分析如下，如果数组的大小为3，储存元素小于等于0的，大于3的，都不会影响到这个题的正确答案，
 * 因为只要存在一个不位于1~3的元素，那么就一定会挤占一个位置，
 * 就导致1~3当中有一个位置的数据是缺失的，那么答案就是缺失的这个位置，因为不会比它更小，
 * 同样，如果有多个缺失的，那就从左到右找缺失的最小的那个，如果都不缺失，那答案一定就是4。
 */
