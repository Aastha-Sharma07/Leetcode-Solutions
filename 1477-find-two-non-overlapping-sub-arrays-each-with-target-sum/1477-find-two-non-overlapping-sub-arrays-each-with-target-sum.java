import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = n + 1;

        int[] minLen = new int[n];
        Arrays.fill(minLen, INF);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int ans = INF;
        int best = INF;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (map.containsKey(sum - target)) {

                int start = map.get(sum - target) + 1;
                int len = i - start + 1;

                if (start > 0 && minLen[start - 1] != INF) {
                    ans = Math.min(ans, len + minLen[start - 1]);
                }

                best = Math.min(best, len);
            }

            minLen[i] = best;

            map.put(sum, i);
        }

        return ans == INF ? -1 : ans;
    }
}