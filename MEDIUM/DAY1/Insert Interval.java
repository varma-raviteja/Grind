Overview
We have NNN non-overlapping intervals in ascending order of their start value; given one more interval newInterval we want to insert this interval in the list keeping the order intact and merging the possible overlapping intervals.

The solution to this problem will be straightforward to understand if we can find the solution to the below three sub-problems.

1. How can we tell if two given intervals overlaps?
2. How to merge two overlapping intervals?
3. Given a list of $N$ intervals in ascending order of their `start` values, how can we merge possible overlapping intervals in the list, keeping the ascending order intact?

Approach 1: Linear Search
Intuition

Since we now understand the answer to the above three sub-problems, let's start with the original problem. How can we convert the original problem into the #3 sub-problem we just discussed above? For this, we will need to insert the newInterval into the original list keeping the start value of intervals in ascending order. So, the new problem is given NNN intervals in ascending order of the start and another interval, newInterval, insert the newInterval in the list in the order of its start value.

This can be done using linear search, we can iterate over the intervals in the list, and the newInterval should be inserted just before the interval having a greater start value. This way, we can produce the list of intervals in ascending order of their start value and solve it using the algorithm discussed in question #3 above.

Current

Algorithm

Insert the newInterval into the given list of intervals using linear search. Iterate over the list and find the first interval with a start value greater than the newInterval. Insert newInterval just before this interval or at the end of the list if no such interval exists.

Iterate over the intervals in the list intervals; for each interval currInterval

Iterate over the intervals ahead of it in the list (including itself), and if the two interval overlaps, update currInterval to the merged interval of these two intervals and move on to the next interval.
Decrement the loop counter variable, as it will be incremented again in the outer loop, and if we don't decrement it here, the next interval will be missed.

Insert the interval currInterval in the list answer.

Return answer.

Implementation
class Solution {
    // Returns true if the intervals a and b have a common element.
    boolean doesIntervalsOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    // Return the interval having all the elements of intervals a and b.
    int[] mergeIntervals(int[] a, int[] b) {
        int[] newInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return newInterval;
    }

    // Insert the interval newInterval, into the list interval keeping the sorting order intact.
    int[][] insertInterval(int[][] intervals, int[] newInterval) {
        boolean isIntervalInserted = false;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                // Found the position, insert the interval and break from the loop.
                list.add(i, newInterval);
                isIntervalInserted = true;
                break;
            }
        }

        // If there is no interval with a greater value of start value,
        // then the interval must be inserted at the end of the list.
        if (!isIntervalInserted) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Insert the interval first before merge processing.
        intervals = insertInterval(intervals, newInterval);

        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            // Merge until the list gets exhausted or no overlap is found.
            while (i < intervals.length && doesIntervalsOverlap(currInterval, intervals[i])) {
                currInterval = mergeIntervals(currInterval, intervals[i]);
                i++;
            }
            // Decrement to ensure we don't skip the interval due to outer for-loop incrementing.
            i--;
            answer.add(currInterval);
        }

        return answer.toArray(new int[answer.size()][2]);
    }
}


Complexity Analysis

Here NNN is the number of intervals in the list.

Time complexity: O(N)O(N)O(N).

Inserting the interval initially will take O(N)O(N)O(N) time as we might end up iterating over the complete list; also, inserting into the list at the mentioned position will take O(N)O(N)O(N) time. Then iterating over the intervals and merging them with intervals ahead of it will take another O(N)O(N)O(N) time. Hence, the total time complexity will equal O(N)O(N)O(N).

Space complexity: O(1)O(1)O(1).

Inserting an interval into the list will take O(1)O(1)O(1) space. Therefore, apart from the list we return, the total space complexity would be constant.

Approach 2: Binary Search
Intuition

The only difference with this approach would be that instead of using linear search to find the suitable position of newInterval, we can use binary search as the list of intervals is sorted in order of their start time.

We need to find the first interval in the list intervals having a start value greater than the start value of newInterval. In languages like C++, we can use STL functions like upper_bound to get the position, or we can implement our own basic binary search algorithm.

Apart from this change, the logic remains the same for this approach; we insert the interval at its place using binary search and then merge the overlapping intervals using the same algorithm we used previously.

Algorithm

Insert the newInterval into the given list intervals using binary search. Find the index using binary search and if it's equal to the size of the list, then add the interval to the end of the list; otherwise, insert it at the respective position.

Iterate over the intervals in the list intervals; for each interval currInterval

Iterate over the intervals ahead of it in the list (including itself), and if the two interval overlaps, update currInterval to the merged interval of these two intervals and move on to the next interval.
Decrement the loop counter variable, as it will be incremented again in the outer loop, and if we don't decrement it here, the next interval will be missed.

Insert the interval currInterval in the list answer.

Return answer.

Implementation

class Solution {
    // Returns true if the intervals a and b have a common element.
    boolean doesIntervalsOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    // Return the interval having all the elements of intervals a and b.
    int[] mergeIntervals(int[] a, int[] b) {
        int[] newInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return newInterval;
    }

    int UpperBound(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            // If the list is empty, just insert the newInterval at the 0th position.
            return 0;
        }

        int start = 0, end = intervals.length - 1;
        int ans = intervals.length;
        while (start <= end) {
            int mid = (start + end) / 2;

            // If the start value is greater than the newInterval
            // This could be the position, so store it but keep looking on the left side.
            if (intervals[mid][0] > newInterval[0]) {
                ans = mid;
                end = mid - 1;
            } else {
                // Search on the right side of mid.
                start = mid + 1;
            }
        }

        return ans;
    }

    // Insert the interval newInterval, into the list interval keeping the sorting order intact.
    int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        int index = UpperBound(intervals, newInterval);

        if (index != intervals.length) {
            list.add(index, newInterval);
        } else {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Insert the interval first before merge processing.
        intervals = insertInterval(intervals, newInterval);

        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            // Merge until the list gets exhausted or no overlap is found.
            while (i < intervals.length && doesIntervalsOverlap(currInterval, intervals[i])) {
                currInterval = mergeIntervals(currInterval, intervals[i]);
                i++;
            }
            // Decrement to ensure we don't skip the interval due to outer for-loop incrementing.
            i--;
            answer.add(currInterval);
        }

        return answer.toArray(new int[answer.size()][2]);
    }
}


Complexity Analysis

Here NNN is the number of intervals in the list.

Time complexity: O(N)O(N)O(N).

Binary search will take O(log⁡N)O(\log N)O(logN) time, but inserting into the list at the returned position will take O(N)O(N)O(N) time. Then iterating over the intervals and merging them with intervals ahead of it will take another O(N)O(N)O(N) time. Hence, the total time complexity will equal O(N)O(N)O(N).

Space complexity: O(1)O(1)O(1).

Inserting an interval into the list will take O(1)O(1)O(1) space. Therefore, apart from the list we return, the total space complexity would be constant.
