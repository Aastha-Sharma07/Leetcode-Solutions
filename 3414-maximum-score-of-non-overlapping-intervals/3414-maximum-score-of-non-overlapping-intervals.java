import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    List<Interval> arr;
    State[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            ));
        }

        arr.sort((a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);
            return Integer.compare(a.r, b.r);
        });

        dp = new State[n][5];

        State ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    private State solve(int i, int remaining) {

        if (i == arr.size() || remaining == 0) {
            return new State(0, new ArrayList<>());
        }

        if (dp[i][remaining] != null) {
            return dp[i][remaining];
        }

        // Don't choose current interval
        State skip = solve(i + 1, remaining);

        // Choose current interval
        Interval cur = arr.get(i);

        int next = findNext(i + 1, cur.r);

        State nextState = solve(next, remaining - 1);

        List<Integer> chosen = new ArrayList<>(nextState.indices);
        chosen.add(cur.idx);

        Collections.sort(chosen);

        State take = new State(
            cur.w + nextState.weight,
            chosen
        );

        dp[i][remaining] = better(take, skip);

        return dp[i][remaining];
    }

    private int findNext(int start, int right) {

        int low = start;
        int high = arr.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Intervals sharing the boundary are overlapping
            if (arr.get(mid).l > right) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private State better(State a, State b) {

        if (a.weight != b.weight) {
            return a.weight > b.weight ? a : b;
        }

        // Same weight → lexicographically smaller indices
        return compare(a.indices, b.indices) < 0 ? a : b;
    }

    private int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}