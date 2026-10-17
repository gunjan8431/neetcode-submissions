class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            Map<Character, Integer> freq = new HashMap<>();

            // Ignore uppercase/lowercase differences
            for (char c : s.toLowerCase(Locale.ROOT).toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }

            // Generate a consistent key
            StringBuilder key = new StringBuilder();

            for (char c = 'a'; c <= 'z'; c++) {
                if (freq.containsKey(c)) {
                    key.append(c)
                       .append(freq.get(c))
                       .append('#');
                }
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
               .add(s);
        }

        return new ArrayList<>(map.values());
    }
}