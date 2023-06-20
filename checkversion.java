public class checkversion {
    /***********
     * Had tooo many solutions but many did't passs allll...(mostly due to long
     * type) this was the most logical one
     ************/
    public static int compareVersions(String a, String b) {
        char[] version1 = a.toCharArray();
        char[] version2 = b.toCharArray();
        int i = 0, j = 0;
        while (i < a.length() || j < b.length()) {
            long num1 = 0;
            long num2 = 0;
            // Process version1
            while (i < a.length() && version1[i] != '.') {
                num1 = num1 * 10 + (version1[i] - '0');
                i++;
            }

            // Process version2
            while (j < b.length() && version2[j] != '.') {
                num2 = num2 * 10 + (version2[j] - '0');
                j++;
            }

            if (num1 < num2)
                return -1;
            if (num1 > num2)
                return 1;

            i++; // Move past the '.'
            j++; // Move past the '.'

        }

        return 0;
    }


    /**************** Completely working one ****************/

    public static int compareVersions1(String a, String b) {
        int firstIdx = 0, secondIdx = 0;
        while (firstIdx < a.length() || secondIdx < b.length()) {
            long first = 0;
            while (firstIdx < a.length() && Character.isDigit(a.charAt(firstIdx))) {
                first = first * 10 + a.charAt(firstIdx++) - '0';
            }

            long second = 0;
            while (secondIdx < b.length() && Character.isDigit(b.charAt(secondIdx))) {
                second = second * 10 + b.charAt(secondIdx++) - '0';
            }

            if (first != second) {
                return Long.compare(first, second); // The first unequal revision number determines the result of the
                                                    // comparison.
            } else {
                firstIdx++;
                secondIdx++; // Skip the current '.' characters so we are ready to parse the next revision
                             // numbers.
            }
        }
        return 0;
    }
}
