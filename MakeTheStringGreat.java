import java.util.Stack;

public class MakeTheStringGreat {
/*
    Approach 1 : We can use the their ASCII values as reference, each character has a unique ASCII value:

        a = 97, A = 65
        b = 98, B = 66
        c = 99, C = 67 ...
        z = 122, Z = 90
        so  2-chars make pairs if there diff is 32
 */
//    T.C. = O(n^2) : each iteration takes O(n) time and in worst-case we can remove one pair in each iteration takes O(n) time
//S.C> = O(n) : after remove we concatenate  the remaining String
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1) {
            boolean isFound = false;

            for (int i = 0; i < sb.length() - 1; i++) {
                char curr = sb.charAt(i);
                char next = sb.charAt(i + 1);

                if(Math.abs(curr - next) == 32) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    isFound = true;
                    break;
                }
            }

            if(!isFound) {
                break;
            }
        }
        return sb.toString();
    }
//    T.C. = O(n) we need only one iteration in each ieration we can remove the last el from the stack or add the curr char
//    S.C. = O(n) space stack is used to store the String
    public static String makeGoodStack(String s) {
        Stack<Character> st = new Stack<>();
        for (char currChar : s.toCharArray()) {
            // If the current character make a pair with the last character in the stack,
            // remove both of them. Otherwise, we the add current character to stack.
            if (!st.isEmpty() && Math.abs(st.lastElement() - currChar) == 32)
                st.pop();
            else
                st.add(currChar);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGoodStack("leEeetcode"));
    }
}
