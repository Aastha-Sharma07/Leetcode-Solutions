import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else {
                map.put(ch1, ch2);
            }

            if (reverseMap.containsKey(ch2)) {
                if (reverseMap.get(ch2) != ch1) {
                    return false;
                }
            } else {
                reverseMap.put(ch2, ch1);
            }
        }

        return true;
    }
}