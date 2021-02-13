package cn.edu.cqvie.se;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSumTest {


    public static void main(String[] args) {
        NumberSumTest test = new NumberSumTest();
        System.out.println(test.getResult(new int[]{1, 421, 3, 4, 51, 7}, 7));
    }

    public List<List<Integer>> getResult(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == n) {
                    int a = nums[i];
                    int b = nums[j];
                    if (nums[i] > nums[j]) {
                        b = nums[i];
                        a = nums[j];
                    }
                    result.add(Arrays.asList(a, b));
                }
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

}
