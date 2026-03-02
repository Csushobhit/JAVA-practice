import java.util.LinkedList;

public class LinkedListDemo
{
    public static void main(String[] args)
    {
        LinkedList<String> list=new LinkedList<>();

        list.add("A");
        list.add("B");
        list.addFirst("Start");
        list.addLast("End");

        System.out.println(list);
    }
}