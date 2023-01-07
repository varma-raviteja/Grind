// Brute force - O(N*N) O(1)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set =new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
            return true;
            else
            set.add(nums[i]);
        }
        return false;
    }
}

// Sorting -O(NlogN) O(1)

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

// HashMap -O(N) O(N)

class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
}

// Binary Bit Manipulation O(NlogC) c=10 power 5
// for a number to be in majority among the arrays, the number of zeros and number of ones for similar numbers are equal. So, count individual bits in majority every time.

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority_element = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;

            // Count how many numbers have this bit set.
            int bit_count = 0;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    bit_count++;
                }
            }

            // If this bit is present in more than n / 2 elements
            // then it must be set in the majority element.
            if (bit_count > n / 2) {
                majority_element |= bit;
            }
        }

        return majority_element;
    }
}


// Divide and Conquer - O(Nlogn) O(logn)

class Solution {
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}

// Boyer-Moore Voting Algorithm O(N) O(1)

// Add +1 when you encounter the candidate which is assumed to be result or -1 otherwise. 
class Solution {
    public int majorityElement(int[] nums) {

        int candidate=-1;
        int count=0;
        for(int num:nums)
        {
            if(count==0)
            candidate=num;

            if(num==candidate)
              count++;
            else count--;
        }
        return candidate;
    }
}
