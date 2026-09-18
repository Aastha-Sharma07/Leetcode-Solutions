import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] == -1) {
                first[ch] = i;
            }

            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Find valid intervals
        for (int i = 0; i < n; i++) {

            // Only start from first occurrence
            if (first[s.charAt(i) - 'a'] != i) {
                continue;
            }

            int left = i;
            int right = last[s.charAt(i) - 'a'];
            boolean valid = true;

            for (int j = left; j <= right; j++) {

                int ch = s.charAt(j) - 'a';

                if (first[ch] < left) {
                    valid = false;
                    break;
                }

                right = Math.max(right, last[ch]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : intervals) {

            if (interval[0] > prevEnd) {
                ans.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }

        return ans;
    }
}