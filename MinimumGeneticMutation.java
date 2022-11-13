import java.util.HashSet;
import java.util.Set;
/*
    Explanation : given 2 string start and end we need to construct the end string from the start in min replacement
    we can replace 1 char in the string at once
    Approach : we need to change a String to another String and Min given so BFS approach
    but rather than doing a Bfs approach and generate all the possible mutation for each nodes and check for its validity
    we simply build the bank.
    we run a loop and iterate the bank array and check if the current node and the ith node has any mutation or not
    if mutation present then add it to our HashSet
    now if the current node != our end Node then do the recursion wiht the current Node we get and find the min ans

 */
public class MinimumGeneticMutation {
    private static int min = Integer.MAX_VALUE;
    public static int minMutation(String start, String end, String[] bank) {
        if(bank.length == 0) return -1;
        solve(start, end, bank, 0, new HashSet<>());
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    // T.C. = O(b ^ 2) we are generating the bank but we know that the b = 10 at max
//    S.C. = O(b) b = bank.length
    private static void solve(String start, String end, String[] bank, int count, Set<String> set){

        if(start.equals(end)){
            min=Math.min(min,count);
            return;
        }
        for(int i=0;i<bank.length;i++){
            if(diff(start,bank[i])==1 && !set.contains(bank[i])){
                set.add(bank[i]);
                solve(bank[i],end,bank,count+1,set);
                set.remove(bank[i]);
            }
        }
    }
    private static int diff(String a,String b){
        int count=0;
        for(int i=0;i<8;i++){
            if(a.charAt(i)!=b.charAt(i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
    }
}
