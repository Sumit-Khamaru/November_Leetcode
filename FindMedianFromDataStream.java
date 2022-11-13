import java.util.PriorityQueue;
import java.util.TreeSet;

public class FindMedianFromDataStream {
    public static void main(String[] args) {

    }
}
/*
    Explanation : we need to find the median of the data-set(sorted).if we maintain the sorted order then calculating median takes O(1) time
    what is median : if the len of the data-set is odd then the middle el is the median
                     else even len we take 2 middle el and add them then / by 2 and that is the median

    so, for incoming el we need to maintain a sorted list, but sorting is an expensive operation takes O(nlogn) time
    for that we use 2 heap MIN and MAX Where " RULE : the largest element(top_el) in the MAX_HEAP will be lower than minimum el(top_el)of MIN_HEAP "

    EXAMPLE :
        input : 1
        1st : if the heaps are empty, the add the current el to MAX_HEAP
        MAX_HEAP  : 1
        MIN_HEAP  :


        input : 7
        2nd :  heap size is > 0, then check the MAX_HEAP top el, if it less than current el add it ot MIN_HEAP
        MAX_HEAP  : 1
        MIN_HEAP  : 7

        if size of 2 HEAPS are same : MEDIAN = 1 + 7 = 8 / 2 = 4

        input : 3
        2nd :  heap size is > 0, then check the MAX_HEAP top el, if it less than current el add it ot MIN_HEAP
        MAX_HEAP  : 1
        MIN_HEAP  : 7, 3

        now the size of 2 HEAPS are odd : then the top most el is the HEAP Which has greater size is the ans



        input : 2
        2nd :  heap size is > 0, then check the MAX_HEAP top el, if it less than current el add it ot MIN_HEAP
        MAX_HEAP  : 1
        MIN_HEAP  : 7, 3, 2

        now the size of 2 HEAPS are even : then the top most el is the HEAP Which has greater size is the ans
        but if we do that we get a false ans, because : 1 , 2, 3, 7 the median is 2 + 3 = 5 / 2 = 2.5

        for this case we check the size diff of 2 HEAPS if the diff > 1 then we do a balance operation, for that we remove the
        top el from the MIN_HEAP add it to the MAX_HEAP

 */
class MedianFinder {
    private PriorityQueue<Integer> maxHeap = null;
    private PriorityQueue<Integer> minHeap = null;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.size() == 0 || maxHeap.peek() >= num) {
            maxHeap.offer(num);
        }
        else {
            minHeap.offer(num);
        }
        balance();
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    private void balance() {
        // means odd number
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size()- maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
}

