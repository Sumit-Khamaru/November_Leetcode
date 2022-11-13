import java.util.Stack;

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner sc = new StockSpanner();
        System.out.println(sc.next(100));
        System.out.println(sc.next(80));
        System.out.println(sc.next(60));
        System.out.println(sc.next(70));
        System.out.println(sc.next(60));
        System.out.println(sc.next(75));
        System.out.println(sc.next(85));
    }
}
class StockSpanner{
    Stack<pair<Integer, Integer>> stack;

    public StockSpanner(){
        stack = new Stack<>();
    }
    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek().val <= price) {
            ans += stack.pop().ind;
        }
        stack.push(new pair<>(ans, price));
        return ans;
    }
}

class pair<T, V>{
    T ind;
    V val;

    pair(T _a, V _b) {
        this.ind = _a;
        this.val = _b;
    }
}