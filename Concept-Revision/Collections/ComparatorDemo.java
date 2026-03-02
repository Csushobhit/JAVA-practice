import java.util.*;

class Student
{
    int id;
    String name;

    Student(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    public String toString()
    {
        return id+" "+name;
    }
}

class NameComparator implements Comparator<Student>
{
    public int compare(Student s1,Student s2)
    {
        return s1.name.compareTo(s2.name);
    }
}

public class ComparatorDemo
{
    public static void main(String[] args)
    {
        ArrayList<Student> list=new ArrayList<>();

        list.add(new Student(1,"Ram"));
        list.add(new Student(2,"Amit"));
        list.add(new Student(3,"Neha"));

        Collections.sort(list,new NameComparator());

        System.out.println(list);
    }
}