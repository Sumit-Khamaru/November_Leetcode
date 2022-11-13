import java.util.HashMap;
import java.util.Map;
/*
    Explanation : we need to make a string from the given String array then return its length
    Approach : there are 2 cases we need to consider
        case1 : when the char of String are not same we need to find its pair like "ab" , "ba" if present we add it to our ans
        case2 : It we have same Char in the String then we need to do same as case 1
            but the catch is if the count of the String is odd then it can be the possible central for odd len Palindrome so, we add count - 1 to ans and the mark the central true
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        String[] arr = {"ab", "ty", "yt", "lc", "cl"};
        System.out.println(longestPalindrome(arr));
    }
//    T.C. = O(n_ n = len of the String array
//    S.C. = O(1) i.e. there are 26 chars in alphabet, if we make len 2 pairs we have 13 string and we consider the reverse of the strings so total (13 + 13) = 26 || s0 we need total 26 * 26 which is constant
    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for (String word : words) {
           count.put(word, count.getOrDefault(word, 0) + 1);
        }
        int answer = 0;
        boolean central = false;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();
            // if the word is a palindrome
            if (word.charAt(0) == word.charAt(1)) {
                if (countOfTheWord % 2 == 0) {
                    answer += countOfTheWord;
                } else {
                    answer += countOfTheWord - 1;
                    central = true;
                }
                // consider a pair of non-palindrome words such that one is the reverse of another
            } else if (word.charAt(0) < word.charAt(1)) {
                String reversedWord = "" + word.charAt(1) + word.charAt(0);
                if (count.containsKey(reversedWord)) {
                    answer += 2 * Math.min(countOfTheWord, count.get(reversedWord));
                }
            }
        }
        if (central) {
            answer++;
        }
        return 2 * answer;
    }
}