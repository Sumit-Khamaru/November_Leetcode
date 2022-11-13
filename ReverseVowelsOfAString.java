public class ReverseVowelsOfAString {
/*
    Explanation : we need to find the vowels and replace them then return the new String
    Approach : This is a 2-pointer Problem
    we make start and end pointer pointing to 0 and len - 1
        1. if start and end are vowels then swap and increase the pointer
        2. else we increase both the pointers
 */
//    T.C. = O(n) n = len of the string
//    S.C. = O(n) return a n size string
    public static String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if(isVowel(str[start]) && isVowel(str[end])) {
                swap(start++, end--, str);
            }
            else if(!isVowel(str[start])) {
                start++;
            }
            else if(!isVowel(str[end])) {
                end--;
            }
        }
        return new String(str);
    }
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    private static void swap(int i, int j, char[] str) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static void main(String[] args) {
        System.out.println(reverseVowels("Hello"));
    }
}
