// QuickSelect O(N) (Average Case) O(Logn)


class Solution {
   public int findKthLargest(int[] nums, int k) {
	return quickSelect(nums, 0, nums.length-1, nums.length-k);
}

private int quickSelect(int[] nums, int left, int right, int k) {
	if (left == right) return nums[left];

	int pIndex = new Random().nextInt(right - left + 1) + left;
	pIndex = partition(nums, left, right, pIndex);

	if (pIndex == k) return nums[k];
	else if (pIndex < k) return quickSelect(nums, pIndex+1, right, k);
	return quickSelect(nums, left, pIndex-1, k);
}

private int partition(int[] nums, int left, int right, int pIndex) {
	int pivot = nums[pIndex];
	swap(nums, pIndex, right);
	pIndex = left;

	for (int i=left; i<=right; i++) 
		if (nums[i] <= pivot) 
			swap(nums, i, pIndex++);

	return pIndex - 1;
}

private void swap(int[] nums, int x, int y) {
	int temp = nums[x];
	nums[x] = nums[y];
	nums[y] = temp;
}
}

// PriorityQueue Min Heap O(Nlogk) O(K)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}

public int findKthLargest(int[] nums, int k) {
	 PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> (b-a));
        for(int  i: nums){
            maxHeap.offer(i);
        }
        while(k != 1){
            maxHeap.poll();
            k--;
        }
        return maxHeap.poll();
}
