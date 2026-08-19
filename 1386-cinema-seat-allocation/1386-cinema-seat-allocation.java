import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store reserved seats for each row
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }

        // Initially, every row can have 2 families
        int result = 2 * n;

        // Check only rows having reserved seats
        for (int row : map.keySet()) {

            HashSet<Integer> reserved = map.get(row);

            // We assumed 2 families for this row,
            // so remove that assumption first.
            result -= 2;

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // Check left group: 2,3,4,5
            for (int seat = 2; seat <= 5; seat++) {
                if (reserved.contains(seat)) {
                    left = false;
                    break;
                }
            }

            // Check middle group: 4,5,6,7
            for (int seat = 4; seat <= 7; seat++) {
                if (reserved.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            // Check right group: 6,7,8,9
            for (int seat = 6; seat <= 9; seat++) {
                if (reserved.contains(seat)) {
                    right = false;
                    break;
                }
            }

            // Left and right can both be used
            if (left && right) {
                result += 2;
            }
            // At least one group can be used
            else if (left || middle || right) {
                result += 1;
            }
        }

        return result;
    }
}