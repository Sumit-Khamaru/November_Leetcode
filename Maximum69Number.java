public class Maximum69Number {
/*
Explanation : The number consists only digit 6 and 9 , we need to change one of the digit to get the maximum then return it.
Approach :
 Observation : 1. we can change only one number
               2. if we change the highest index number in 9 we get the maximum value Suppose num = 669,
               it has multiple digits 6, we must convert the first one to make it 969 rather than 699.
               3.If every digit of num is 9, we only need to return num since it already stands for the largest integer.
 */
//    T.C. = we traverse the String of len l so O(l)
//    S.C. = O(n) to convert the num to string
    public static int maximum69Number (int num) {
        // change the input in String for traversal
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '6') {
                sb.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
//    T.C. = O(l)
//    S.C. = O(1)
    public static int maximum69Number1 (int num) {
        // Since we start with the lowest digit, initialize currDigit = 0.
        int numCopy = num;
        int indexSix = -1;
        int currDigit = 0;

        // Check every digit of 'numCopy' from low to high.
        while (numCopy > 0) {
            // If the current digit is '6', record it as the highest digit of 6.
            // we find the height position of "6" in num
            if (numCopy % 10 == 6) {
                indexSix = currDigit;
            }

            // Move on to the next digit.
            numCopy /= 10;
            currDigit++;
        }

        // If we don't find any digit of '6', return the original number,
        // otherwise, increment 'num' by the difference made by the first '6'.
        // to make the 6 -> 9 we have to add 3 to it so, we do 3 * the position of the height 6
        return indexSix == -1 ? num : num + 3 * (int)Math.pow(10, indexSix);
    }
    public static void main(String[] args) {
        System.out.println(maximum69Number1(9669));
    }
}
