import java.util.*;

class Solution {
    int index = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (index < s.length() && s.charAt(index) != '}') {

            if (s.charAt(index) == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                index++;
            }

            else if (s.charAt(index) == '{') {
                index++;

                Set<String> inside = parse(s);

                index++; // skip '}'

                current = concatenate(current, inside);
            }

            else {
                char ch = s.charAt(index);
                index++;

                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));

                current = concatenate(current, letter);
            }
        }

        result.addAll(current);

        return result;
    }

    private Set<String> concatenate(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}