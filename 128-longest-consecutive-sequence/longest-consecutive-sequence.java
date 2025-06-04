
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                int totalLen = left + right + 1;
                map.put(num, totalLen);

                // Update boundary values
                map.put(num - left, totalLen);
                map.put(num + right, totalLen);

                maxLen = Math.max(maxLen, totalLen);
            }
        }

        return maxLen;
    }
}
