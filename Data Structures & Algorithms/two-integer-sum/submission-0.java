class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> counter = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            int diff = target-num;
            if(counter.containsKey(diff))
            {
                return new int[]{counter.get(diff),i};
            }
            counter.put(num,i);
        }
      return new int[]{};
    }
}
