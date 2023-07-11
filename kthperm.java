import java.util.ArrayList;

public class kthperm {
    public static String kthPermutation(int n, int k) {
        // Write your code here.
        // String str = IntStream.rangeClosed(1,n)
        // .mapToObj(Integer :: toString)
        // .collect(Collectors.joining(""));
        ArrayList<Integer> num = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            num.add(i);
        }
        num.add(n);
        String ans = "";
        k--;
        while (true) {
            ans += num.get(k / fact);
            num.remove(k / fact);
            if (num.size() == 0)
                break;
            k = k % fact;
            fact = fact / num.size();
        }
        return ans;
    }
}