package Sept14;

import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String str : dictionary) {
            int i = 0, j = 0;
            while (i < str.length() && j < s.length()) {
                if (str.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i == str.length()) {
                if (str.length() > res.length() || (str.length() == s.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }
        return res;
    }
}
