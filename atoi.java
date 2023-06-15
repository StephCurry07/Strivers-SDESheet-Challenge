public class atoi {
    public static int javaatoi(String str) {
        int ans = 0;
        boolean flag = false;
        if(str.charAt(0) == '-')
            flag = true;
        for(char a : str.toCharArray()){
            if(Character.isDigit(a)){
                ans = ans * 10 + Integer.parseInt(a + "");
            }
        }
        return flag == true ? -1*ans : ans;
    }
}
