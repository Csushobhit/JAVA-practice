import java.util.HashMap;

public class HashMapDemo
{
    public static void main(String[] args)
    {
        HashMap<Integer,String> map=new HashMap<>();

        map.put(1,"Ram");
        map.put(2,"Neha");

        System.out.println(map);

        System.out.println(map.get(1));
    }
}