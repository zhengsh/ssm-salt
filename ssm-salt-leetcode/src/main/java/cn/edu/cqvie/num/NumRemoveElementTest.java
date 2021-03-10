package cn.edu.cqvie.num;

public class NumRemoveElementTest {

    public static void main(String[] args) {
        NumRemoveElementTest test = new NumRemoveElementTest();
        int[] nums = {1, 2, 4, 3};
        int j = test.removeElement(nums, 3);
        System.out.println(j);
        System.out.println();
        for (int i = 0; i < j; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }


    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
