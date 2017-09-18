boolean containsCloseNums(int[] nums, int k) {
    // Maps each value to its latest occurence's index
    Hashtable<Integer, Integer> indexTable = new Hashtable<>();
    
    for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        if(!indexTable.containsKey(num)) {
            indexTable.put(num, i);
        } else {
            if(i - indexTable.get(num) <= k) {
                return true;
            } else {
                indexTable.put(num, i);
            }
        }
    }

    return false;
}
