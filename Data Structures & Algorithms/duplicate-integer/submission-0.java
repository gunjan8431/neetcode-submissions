class Solution {
    public boolean hasDuplicate(int[] nums) {
     
Set<Integer>resultSet =new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
             if(resultSet.contains(nums[i]))
             {
               return true;
         
             }
             resultSet.add(nums[i]);
        }
     return false;
    }
}
