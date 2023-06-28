import java.util.Arrays;

public class LcPrefix {

/************ CN Accepted but LC didn't ************/
    public static String longestCommonPrefix(String[] arr, int n) {
        // Write your code here
        char[] ans = arr[0].toCharArray();
        int loop = ans.length;
        int temp = loop;
        for (String a : arr) {
            for (int i = 0; i < temp; i++) {
        //Failed:
            // if (a.length() > i && a.charAt(i) != ans[i]) { 
        /* fails here if the strings are decreasing in length continuously having same prefix */
            // ans[i] = '-';
            // loop = i;
            // break;
            // }
            // }
        //Improved:
                if (a.length() > i && a.charAt(i) == ans[i]) {
                    continue;
                } else {
                    temp = Math.min(temp, i);
                    break;
                }
            }
        }
        String str = "";
        for (int i = 0; i < loop; i++) {
            str += ans[i];
        }
        return str;
    }

 /************** Amazing Solution *************/
    public static String longestCommonPrefix1(String[] arr, int n) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[arr.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
