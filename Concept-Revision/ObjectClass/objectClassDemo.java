class Student
{
    int id;

    Student(int id)
    {
        this.id = id;
    }

    public String toString()
    {
        return "ID is " + id;
    }

    public static void main(String[] args)
    {
        Student s = new Student(10);

        System.out.println(s);
    }
}