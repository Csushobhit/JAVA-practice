import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>
{
    int id;
    String name;

    Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int compareTo(Student s)
    {
        return this.id - s.id;
    }

    public String toString()
    {
        return id + " " + name;
    }
}

public class ArrayListComparableDemo
{
    public static void main(String[] args)
    {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(3,"Ram"));
        list.add(new Student(1,"Amit"));
        list.add(new Student(2,"Neha"));

        Collections.sort(list);

        System.out.println(list);
    }
}