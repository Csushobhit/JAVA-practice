import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list=new ArrayList<>();

        list.add(10);
        list.add(20);

        Iterator<Integer> it=list.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}