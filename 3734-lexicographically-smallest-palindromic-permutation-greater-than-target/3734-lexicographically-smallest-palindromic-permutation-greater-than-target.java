class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        char[] half = new char[halfLen];

        return solve(halfFreq, target, middle, half, 0);
    }

    private String solve(int[] freq, String target, char middle,
                         char[] half, int pos) {

        if (pos == half.length) {
            StringBuilder ans = new StringBuilder();

            for (char c : half) {
                ans.append(c);
            }

            if (half.length * 2 + 1 == target.length()) {
                ans.append(middle);
            }

            for (int i = half.length - 1; i >= 0; i--) {
                ans.append(half[i]);
            }

            String result = ans.toString();

            if (result.compareTo(target) > 0) {
                return result;
            }

            return "";
        }

        int limit = 25;

        if (pos < target.length()) {
            limit = target.charAt(pos) - 'a';
        }

        // First try to stay equal to target
        if (limit >= 0 && freq[limit] > 0) {
            half[pos] = (char) ('a' + limit);
            freq[limit]--;

            String result = solve(freq, target, middle, half, pos + 1);

            freq[limit]++;

            if (!result.equals("")) {
                return result;
            }
        }

        // Now try a character greater than target[pos]
        for (int c = limit + 1; c < 26; c++) {
            if (freq[c] > 0) {

                half[pos] = (char) ('a' + c);
                freq[c]--;

                int index = pos + 1;

                for (int x = 0; x < 26; x++) {
                    while (freq[x] > 0) {
                        half[index++] = (char) ('a' + x);
                        freq[x]--;
                    }
                }

                StringBuilder ans = new StringBuilder();

                for (char ch : half) {
                    ans.append(ch);
                }

                if (half.length * 2 + 1 == target.length()) {
                    ans.append(middle);
                }

                for (int i = half.length - 1; i >= 0; i--) {
                    ans.append(half[i]);
                }

                return ans.toString();
            }
        }

        return "";
    }
}