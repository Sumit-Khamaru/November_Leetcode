import java.util.Arrays;
/*
Explanation : we need to find the lexicographically smallest String by replacing the k number of element at the end
Approach :
    case 1 :
    when the k == 1 means we can change the first char of the string to the end
    here we are simply doing a rotation operation, so we need to handle this case
    case 2 :
    when k == 2 we can change the position any of first 2 chars so wew can ge the possibly smallest lexicographical String

 */

// T.C. = O(n) to build all the possible Strings and we run a loop to the len of hte String takes O(n^2)
// S.C. = O(n)
public class OrderlyQueue {
    public static String orderlyQueue(String s, int k) {
        if(k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                // building the Strings
                String temp = s.substring(i) + s.substring(0, i);

                if(temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        }
        else {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }
    }

    public static void main(String[] args) {
        String a = "cba";
        String b = "baaca";
        System.out.println(orderlyQueue(a, 1));
        System.out.println(orderlyQueue(b, 3));
    }
}
