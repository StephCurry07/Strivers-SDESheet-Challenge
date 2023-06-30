import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobScheduling {
    class Job{
        int deadline;
        int profit;
        Job(int deadline, int profit){
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    
    class JobComparator implements Comparator<Job>{
        @Override
        public int compare(Job o1, Job o2){
            return (o2.profit - o1.profit);
        }
    }
    public static int jobScheduling(int[][] jobs) {
        ArrayList<Job> list = new ArrayList<>();
        int max_deadline = 0;
        for(int i = 0; i < jobs.length; i++){
            list.add(new Job(jobs[i][0], jobs[i][1]));
            max_deadline = Math.max(max_deadline, jobs[i][0]);
        }
        JobComparator jc = new JobComparator();
        Collections.sort(list, jc);
        int[] arr = new int[max_deadline + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            Job j = list.get(i);
            int back = j.deadline;
            for(int k = back; k > 0; k--){
                if(arr[k] == -1){
                    arr[k] = j.profit;
                    sum += arr[k];
                    break;
                }
            }
        }
        return sum;
    }
}
