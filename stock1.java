import java.util.ArrayList;

public class stock1 {
    public static int maximumProfit(ArrayList<Integer> prices){
        int max_prof = 0;
        int cur_price = prices.get(0);
        for(int i = 1; i < prices.size(); i++){
            if(cur_price < prices.get(i)){
                max_prof = Math.max(max_prof, prices.get(i) - cur_price);
            }
            else{
                cur_price = prices.get(i);
            }
        }
        return max_prof;
    }
}
