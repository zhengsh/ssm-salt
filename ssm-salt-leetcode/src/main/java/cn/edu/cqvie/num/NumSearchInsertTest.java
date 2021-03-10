package cn.edu.cqvie.num;

public class NumSearchInsertTest {

    public static void main(String[] args) {
        NumSearchInsertTest test = new NumSearchInsertTest();
        int i = test.searchInsert(new int[]{1, 3, 5, 7}, 2);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int left =0; int right = nums.length -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
