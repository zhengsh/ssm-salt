package cn.edu.cqvie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution4 {

//    4. 寻找两个正序数组的中位数
//    给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//
//    进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
//
//             
//
//    示例 1：
//
//    输入：nums1 = [1,3], nums2 = [2]
//    输出：2.00000
//    解释：合并数组 = [1,2,3] ，中位数 2
//    示例 2：
//
//    输入：nums1 = [1,2], nums2 = [3,4]
//    输出：2.50000
//    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//    示例 3：
//
//    输入：nums1 = [0,0], nums2 = [0,0]
//    输出：0.00000
//    示例 4：
//
//    输入：nums1 = [], nums2 = [1]
//    输出：1.00000
//    示例 5：
//
//    输入：nums1 = [2], nums2 = []
//    输出：2.00000
//             
//
//    提示：
//
//    nums1.length == m
//    nums2.length == n
//            0 <= m <= 1000
//            0 <= n <= 1000
//            1 <= m + n <= 2000
//            -106 <= nums1[i], nums2[i] <= 106

    public static void main(String[] args) {
        Solution4 solution1 = new Solution4();
        double sortedArrays = solution1.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(sortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1. 合并
        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);

        // 2. 排序
        Arrays.sort(arr);

        // 3. 计算中位数
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        } else {
            if (arr.length == 0) {
                return 0;
            }
            return ((double) (arr[arr.length / 2 - 1] + arr[arr.length / 2])) / 2;
        }
    }
}
