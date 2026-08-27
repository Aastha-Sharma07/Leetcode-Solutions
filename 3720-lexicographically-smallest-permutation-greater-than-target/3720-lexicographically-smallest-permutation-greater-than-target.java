class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int i = 0;

        // Match target as much as possible
        while (i < n) {
            int ch = target.charAt(i) - 'a';

            if (freq[ch] == 0) {
                break;
            }

            freq[ch]--;
            i++;
        }

        // Try to make one position greater
        for (int pos = i; pos >= 0; pos--) {

            if (pos < i) {
                freq[target.charAt(pos) - 'a']++;
            }

            if (pos == n) {
                continue;
            }

            int current = target.charAt(pos) - 'a';

            for (int next = current + 1; next < 26; next++) {

                if (freq[next] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Keep target prefix
                    ans.append(target, 0, pos);

                    // Make this position greater
                    ans.append((char) ('a' + next));

                    freq[next]--;

                    // Smallest possible remaining characters
                    for (int c = 0; c < 26; c++) {
                        while (freq[c] > 0) {
                            ans.append((char) ('a' + c));
                            freq[c]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}