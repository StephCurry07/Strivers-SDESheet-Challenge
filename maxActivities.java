import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Activity{
    int key;
    int value;
    public Activity(int a, int b){
        key = a;
        value = b;
    }
}
public class maxActivities {

/*************** Could think but couldn't implement *************/
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        List<Activity> al = new ArrayList<Activity>();
        for(int i = 0; i < start.size(); i++){
            al.add(new Activity(start.get(i), end.get(i)));
        }
        Collections.sort(al, Comparator.comparingInt(a -> a.value));
        int lastFinish = 0;
        int count = 0;
        for(int i = 0; i < start.size(); i++){
            Activity current = al.get(i);
            if (current.key >= lastFinish) {
                count++;
                lastFinish = current.value;
            }
        }
        return count;
    }
}
