/*
56. Merge Intervals
Medium

16383

585

Add to List

Share
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] curr=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>curr[1]){
                ans.add(curr);
                curr=intervals[i];
            }else{
                curr[1]=Math.max(curr[1],intervals[i][1]);
            }
        }
		//add last curr
        ans.add(curr);
        return ans.toArray(new int[ans.size()][2]);
    }
}