class RandomizedSet {
    HashMap<Integer,Integer> map;
    int arr[];
    Random random;
    int index=0;
    public RandomizedSet() {
        map=new HashMap<>();
        arr=new int[10000001];
        random=new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
        return false;

        arr[index]=val;
        map.put(val,index);
        index++;
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
        return false;

        int idx=map.remove(val);
        // swap the to be removed element with the last element and update the hashmap with the modified index.
        arr[idx]=arr[index-1];
        if(map.containsKey(arr[index-1]))
        map.put(arr[index-1],idx);
        index--;
        return true;
    }
    
    public int getRandom() {
        return arr[random.nextInt(index)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
