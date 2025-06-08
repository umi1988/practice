import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDS
{
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>(10);
        q.add(10);
        q.add(1);
        q.add(12);
        q.add(99);
        q.add(88);
        q.offer(100);
        System.out.println("Size:- " + q.size());
        System.out.println(q);
        System.out.println("Peek:- " + q.peek());
        System.out.println("Poll:- " + q.poll());
        System.out.println("Remove :- " + q.remove());
        System.out.println(q);
    }
}
