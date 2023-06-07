public class remdup {
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
            if(map.get(a) > 1) return a;
        }
        return -1;
    }
}
