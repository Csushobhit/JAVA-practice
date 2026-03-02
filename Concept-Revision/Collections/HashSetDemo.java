import java.util.HashSet;

public class HashSetDemo
{
    public static void main(String[] args)
    {
        HashSet<Integer> set=new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(10);

        System.out.println(set);
    }
}