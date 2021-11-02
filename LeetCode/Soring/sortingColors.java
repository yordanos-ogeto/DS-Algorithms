class sortingColors {
    // -- Problem 75
    /**
     * Given an array nums with n objects colored red, white, or blue, sort them
     * in-place so that objects of the same color are adjacent, with the colors in
     * the order red, white, and blue.
     * 
     * We will use the integers 0, 1, and 2 to represent the color red, white, and
     * blue, respectively.
     * 
     * You must solve this problem without using the library's sort function.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Example 2:
     * 
     * Input: nums = [2,0,1] Output: [0,1,2] Example 3:
     * 
     * Input: nums = [0] Output: [0] Example 4:
     * 
     * Input: nums = [1] Output: [1]
     * 
     * 
     * Constraints:
     * 
     * n == nums.length 1 <= n <= 300 nums[i] is 0, 1, or 2.
     * 
     * 
     * Follow up: Could you come up with a one-pass algorithm using only constant
     * extra space?
     */
    private int[] merge_sort(int[] arr) {
        int array_len = arr.length;
        if (array_len > 1) {
            int[] left = java.util.Arrays.copyOfRange(arr, 0, array_len / 2);
            int[] right = java.util.Arrays.copyOfRange(arr, array_len / 2, array_len);
            left = merge_sort(left);
            right = merge_sort(right);
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k += 1;
            }
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        return arr;
    }

    public void sortColors(int[] nums) {
        nums = merge_sort(nums);
    }
}