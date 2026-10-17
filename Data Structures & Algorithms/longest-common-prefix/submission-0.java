class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = strs[0].length();

        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        int i = 0;

        while (i < minLen) {
            char ch = strs[0].charAt(i);

            for (String s : strs) {
                if (s.charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }

            i++;
        }

        return strs[0].substring(0, i);
    }
}