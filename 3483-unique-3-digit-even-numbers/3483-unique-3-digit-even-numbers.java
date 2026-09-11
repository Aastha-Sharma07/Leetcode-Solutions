class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for(int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for(int i = 1; i <= 9; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= 8; k += 2) {

                    freq[i]--;
                    freq[j]--;
                    freq[k]--;

                    if(freq[i] >= 0 && freq[j] >= 0 && freq[k] >= 0) {
                        count++;
                    }

                    freq[i]++;
                    freq[j]++;
                    freq[k]++;
                }
            }
        }

        return count;
    }
}