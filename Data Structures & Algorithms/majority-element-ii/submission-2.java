class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
         List<Integer> result = new ArrayList<Integer>();
        for(int num :nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if (entry.getValue()> nums.length/3)
            {
            result.add(entry.getKey());
            }
        }
        return result;
    }
}