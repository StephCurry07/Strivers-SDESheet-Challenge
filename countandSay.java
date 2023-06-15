public class countandSay {
/********** Use String Builder for string operations...my logic was good but implementation...See this...easy to read and implement *******/
    public static String writeAsYouSpeak(int n) {
        String result = "1";

        while(n != 0){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);
            
            for (int j = 1; j < result.length(); j++) {
                char curr = result.charAt(j);
                
                if (curr == prev) {
                    count++;
                } else {
                    sb.append(count).append(prev);
                    count = 1;
                    prev = curr;
                }
            }
            
            sb.append(count).append(prev);
            result = sb.toString();
            n--;
        }
        return result;
    }
}
