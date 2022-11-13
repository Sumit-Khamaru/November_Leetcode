import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    /*
      T.C. = O(n) n = len of the String
      S.C. = O(n + m) to make the n size Stack and the StringBuilder :worst case there are all unique chars
     */
//    public static String removeDuplicates2(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        for (int i = 0; i < s.length() - 1; i++) {
//            for (int j = i + 1; j < s.length() ; j++) {
//                if(s.charAt(i) == s.charAt(j)) {
//                    sb.deleteCharAt(i);
//                    sb.deleteCharAt(j - 1);
//                    break;
//                }
//            }
//        }
//        return sb.toString();
//    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        String sb = "";
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
       while (!stack.isEmpty()) {
         sb = stack.pop() + sb;
       }
        return sb.toString();
    }
    /*
    Approach : we make an empty String sb ,we iterate the main String and every time we compare with the sb string for duplicate char if preset
    then delete the top char in the sb else add it to ans
    T.C. = O(n) n = len of the String
    S.C. = O(n) worst case there are all unique chars
     */
    public static String removeDuplicates1(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            int size = sb.length();
            if(size > 0 && sb.charAt(size - 1) == ch) {
                sb.deleteCharAt(size - 1);
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
//        System.out.println(removeDuplicates("abbaca"));
//        System.out.println(removeDuplicates1("abbaca"));
//        System.out.println(removeDuplicates2("abbaca"));
    }
}
