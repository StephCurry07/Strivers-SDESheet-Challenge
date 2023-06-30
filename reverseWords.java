public class reverseWords {
    /******* Using StringBuilder *********/
    public static String reverseString(String str) {
        str.trim();
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isAlphabetic(str.charAt(i))) {
                StringBuilder temp = new StringBuilder();
                while (i >= 0 && str.charAt(i) != ' ') {
                    temp.append(str.charAt(i--));
                }
                res.append(temp.reverse());
                if (i != 0) {
                    res.append(' ');
                }
            }
        }
        return res.toString();
        // Write your code here
    }

/********** Without using SB (1 case not passing) *********/
    public static String reverseString1(String str) {
        int n = str.length();
        String result = "";
        int i = 0;
        while(i < n){
            while(i < n && str.charAt(i) == ' ')
                i++;
            if(i >= n)
                break;
            int j = i + 1;
            while(j < n && str.charAt(j) != ' ')
                j++;
            String sub = str.substring(i, j);
            if(result.length() == 0)
                result = sub;
            else
                result = sub + " " + result;
			i = j + 1;
        }
        return result;
    }
}
