class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains((int) ((long) num - 1))) {
    long next = (long) num + 1;
    int length = 1;

    while (next <= Integer.MAX_VALUE
            && numSet.contains((int) next)) {
        length++;
        next++;
    }
    longest = Math.max(longest, length);
}
                
            }
            return longest;
        }
        
    }


