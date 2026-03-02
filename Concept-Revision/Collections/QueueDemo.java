import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo
{
    public static void main(String[] args)
    {
        Queue<Integer> q=new LinkedList<>();

        q.add(10);
        q.add(20);

        System.out.println(q.poll());

        System.out.println(q);
    }
}