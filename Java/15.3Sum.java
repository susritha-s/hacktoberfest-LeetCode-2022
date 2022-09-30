/*


15. 3Sum
Medium

21581

1990

Add to List

Share
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i != 0 && arr[i - 1] == arr[i]) {
                continue;
            }

            int low = i + 1;
            int high = arr.length - 1;
            
            while(low < high) {
                int cal = arr[i] + arr[low] + arr[high];
                
                if(cal == 0) {
                    res.add(Arrays.asList(arr[i], arr[low], arr[high]));
                    
                    low++;
                    high--;
                    
                    while(low < high && arr[low - 1] == arr[low]) {
                        low++;
                    }
                } else if(cal > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }

        return res;
    }
}