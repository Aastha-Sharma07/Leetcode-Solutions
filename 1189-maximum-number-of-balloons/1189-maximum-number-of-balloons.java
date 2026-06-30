class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        // count frequency
        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }

        // calculate result
        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a'] / 2;
        int o = freq['o' - 'a'] / 2;
        int n = freq['n' - 'a'];

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}