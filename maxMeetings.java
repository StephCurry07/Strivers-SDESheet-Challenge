import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class maxMeetings {
/********** Always create a custom class in these type of questions...and try using comparator ***********/
    class Meeting{
        int start;
        int end;
        int num;
        Meeting(int start, int end, int num){
            this.start = start;
            this.end = end;
            this.num = num;
        }
    }
    class meetingComparator implements Comparator<Meeting>{
    @Override
        public int compare(Meeting o1, Meeting o2){
            if(o1.end < o2.end){
                return -1;
            }
            if(o1.end > o2.end)
                return 1;
            else if(o1.num < o2.num)
                return -1;
            return 1;
        }
    }
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
        List<Integer> ans = new ArrayList<>();
        ArrayList<Meeting> list = new ArrayList<>();
        for(int i = 0; i < start.length; i++){
            list.add(new Meeting(start[i], end[i], i+1));
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(list, mc);
        int lim = list.get(0).end;
        ans.add(list.get(0).num);
        for(int i = 1; i < list.size(); i++){
            int st = list.get(i).start;
            if(st > lim){
                ans.add(list.get(i).num);
                lim = list.get(i).end;
            }
        }
        return ans;
    }
}
