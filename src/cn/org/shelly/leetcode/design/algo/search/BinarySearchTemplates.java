package cn.org.shelly.leetcode.design.algo.search;

/**
 * 二分查找模板类
 * 包含三种常见二分查找形式：
 * 1. 精确查找 / 插入位置模板
 * 2. 第一个满足条件 / lower_bound 模板
 * 3. 答案二分 / 单调函数模板
 *
 * 同时注释了适用的题目类型或示例。
 */
public class BinarySearchTemplates {

    /**
     * 模板 A：精确查找或插入位置
     * 适用题目：
     * - 查找目标元素是否存在
     * - 查找插入位置
     * 特点：
     * - 循环条件 while(left <= right)
     * - left 和 right 初始化为有效下标 0..n-1
     * - 退出时 left 就是插入位置
     */
    /*
        二分查找每时每刻l，r都是继承原有区间性质，如果是[ )，
        那么right就不能更新为-1，应该他代表开区间，-1+)表示取不到左边
        但左边可能是正确答案
     */
    public static int searchExactOrInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 如果这里是nums.length
        while (left <= right) { // 那这里就应该是 <
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;  // 这里就应该是mid
        }
        return left; // 插入位置
    }

    /**
     * 模板 B：查找第一个满足条件的元素 (lower_bound)
     * 适用题目：
     * - 查找第一个 >= target 的元素
     * - 查找第一个满足单调条件的下标
     * 特点：
     * - 循环条件 while(left < right)
     * - right 可以初始化为 nums.length
     * - 退出时 left == right
     */
    public static int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left; // 第一个 >= target 的下标
    }

    /**
     * 模板 C：答案二分 / 单调函数
     * 适用题目：
     * - 答案在区间内，且函数 f(x) 单调
     * - LeetCode 875 爱吃香蕉、2140 等
     * 特点：
     * - left, right 定义为问题区间
     * - 循环条件 while(left < right)
     * - 根据 f(mid) 判断 mid 是否满足条件
     */
    public static int answerBinarySearch(int left, int right, java.util.function.IntPredicate f) {
        // 找满足条件的最大值，区间为 [left, right]
        while (left < right) {
            int mid = left + (right - left + 1) / 2; // +1 避免死循环
            if (f.test(mid)) left = mid;  // mid 满足条件，向右查找
            else right = mid - 1;         // mid 不满足条件，向左查找
        }
        return left;
    }

    /**
     * 示例 main
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        // 模板 A
        int posA = searchExactOrInsert(nums, target);
        System.out.println("模板 A: pos = " + posA);

        // 模板 B
        int posB = lowerBound(nums, 4);
        System.out.println("模板 B: lower_bound = " + posB);

        // 模板 C
        int left = 0, right = 10;
        // 找 <=7 的最大值
        int posC = answerBinarySearch(left, right, x -> x <= 7);
        System.out.println("模板 C: answer = " + posC);
    }
}
