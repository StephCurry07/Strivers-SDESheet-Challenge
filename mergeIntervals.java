import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start, finish;

    Interval(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class mergeIntervals {

/******** Sort - Arrays.sort(lambda comparator) works in arrays.sort also ********/
    public static List<Interval> mergeIntervals1(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        // System.out.println(Arrays.toString(intervals));
        int start = intervals[0].start;
        int end = intervals[0].finish;
        List<Interval> ans = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            if(end >= intervals[i].start){
                end = Math.max(end, intervals[i].finish);
            }
            else{
                ans.add(new Interval(start, end));
                start = intervals[i].start;
                end = intervals[i].finish;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}
