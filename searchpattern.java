public class searchpattern {
    /********* Naive Method O(m * n) ***********/
    public static boolean findPattern(String p, String s) {
        return s.contains(p);
    }

    /*********** KMP Algorithm O(m + n) ***********/

    public static boolean findPatternKMP(String p, String s) {
        int[] lps = computeLPSArray(p);
        int i = 0; // index for traversing the s
        int j = 0; // index for traversing the p

        while (i < s.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j == p.length()) {
                    j = lps[j - 1];
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public static int[] computeLPSArray(String pattern) {

        int[] lps = new int[pattern.length()];
        int j = 0; // length of the previous longest prefix suffix

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                    i--; // recheck current character with new j value
                } else {
                    lps[i] = 0;
                }
            }
        }
        return lps;
    }
}