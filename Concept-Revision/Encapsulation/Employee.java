class Employee
{
    private double salary;

    public void setSalary(double s)
    {
        salary = s;
    }

    public double getSalary()
    {
        return salary;
    }
}

class Test
{
    public static void main(String[] args)
    {
        Employee e = new Employee();

        e.setSalary(50000);

        System.out.println(e.getSalary());
    }
}