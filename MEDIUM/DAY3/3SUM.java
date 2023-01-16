without sort
    //Runtime: 384 ms, faster than 24.18% of Java online submissions for 3Sum.
    //Memory Usage: 120.2 MB, less than 15.92% of Java online submissions for 3Sum.
    //without sort
    //Time: O(N * N * log3); Space:O(N)
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet();

        Set<Integer> duplicatedSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if (!duplicatedSet.add(nums[i])) continue;

            for (int j = i + 1; j < nums.length; j++) {
                int value = 0 - nums[i] - nums[j];
                if (map.containsKey(value) && map.get(value) == i) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], value));
                    Collections.sort(list);
                    resultSet.add(list);
                }
                map.put(nums[j], i);
            }
        }
        return new ArrayList<>(resultSet) ;
    }
Two pointers

    //Runtime: 47 ms, faster than 35.83% of Java online submissions for 3Sum.
    //Memory Usage: 60.1 MB, less than 32.20% of Java online submissions for 3Sum.
    //Two pointers
    //Time: O(N * LogN + N * N); Space : O(N + LogN)
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(nums);

        for(int i = 0; i <= nums.length - 3 && nums[i] <= 0;){
            int left = i + 1, right = nums.length - 1;
            if (0 - nums[i] - nums[left] < 0) break;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--; //skip duplicated number
                } else {
                    if (sum == 0) {
                        resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
            i++;
            while(i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
        }
        return new ArrayList<>(resultSet);
    }
Binary Search

    //Runtime: 99 ms, faster than 29.77% of Java online submissions for 3Sum.
    //Memory Usage: 60.2 MB, less than 31.74% of Java online submissions for 3Sum.
    //Binary Search
    //Time: O(N * logN + N * N * logN); Space:O(N + LogN)
    public List<List<Integer>> threeSum_3(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2 && nums[i] <= 0;){
            for (int j = i + 1; j < nums.length && nums[i] + nums[j] <= 0;) {
                int value = 0 - nums[i] - nums[j];
                if (value < 0) return new ArrayList<>(resultSet);
                int idx = Arrays.binarySearch(nums, j + 1, nums.length, value);
                if (idx >= 0)
                    resultSet.add(Arrays.asList(nums[i], nums[j], value));
                j++;
                while (j < nums.length && nums[j] == nums[j - 1]) j++;
            }
            i++;
            while(i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
        }
        return new ArrayList<>(resultSet);
    }
HashMap

    //Runtime: 106 ms, faster than 29.54% of Java online submissions for 3Sum.
    //Memory Usage: 70.8 MB, less than 23.87% of Java online submissions for 3Sum.
    //HashMap
    //Time:O(N * logN + N * N); Space: O(N + logN + N)
    public List<List<Integer>> threeSum_2(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) map.put(nums[i], i);

        for(int i = 0; i < nums.length - 2 && nums[i] <= 0;){
            for (int j = i + 1; j < nums.length && nums[i] + nums[j] <= 0;) {
                int value = 0 - nums[i] - nums[j];
                //if (value < 0) break;
                if (value < 0) return new ArrayList<>(resultSet);
                if (value < nums[j]) break;
                if (map.containsKey(value) && map.get(value) > j)
                    resultSet.add(Arrays.asList(nums[i], nums[j], value));
                j++;
                while(j < nums.length && nums[j] == nums[j - 1]) j++;
            }
            i++;
            while(i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
        }
        return new ArrayList<>(resultSet) ;
    }
brute force

    //TLE
    //brute force
    //Time: O(N * N * N * log3); Space: O(N)
    public List<List<Integer>> threeSum_brute(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet();
        for (int i = 0; i < nums.length - 2; i++)
            for (int j= i + 1; j < nums.length - 1; j++)
                for (int k = j + 1 ; k < nums.length; k++)
                    if (0 == nums[i] + nums[j] + nums[k]) {
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(list);
                        resultSet.add(list);
                    }
        return new ArrayList<>(resultSet);
    }
	
