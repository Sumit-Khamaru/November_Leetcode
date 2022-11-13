import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
/*
    Explanation : we need to remove the duplicate el from the array and return the len of the duplicate free array,
    Now the catch is there is some internal implementation which checks the "k sorted el" is present in the array or not
    Approach:
        we can't make new Array object, we have to modify the given array
        we use a 2-pointers approach, we start traverse the array from 1 - len() and find the different num
        if we find replace that, now for that we need another pointer which keep track of this
 */
//    T.C. = O(n)
//    S.C. = O(1)
    public static int removeDuplicates(int[] nums) {
       // keep track of the replaced numbers
        int i = 1;
        for (int j = 1; j <nums.length ; j++) {
            if(nums[j-1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int[] a1 = {1, 1, 2};
        System.out.println(removeDuplicates(a));
    }
}
