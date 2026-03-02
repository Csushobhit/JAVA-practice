class Basic
{
    int x = 10;

    public static void main(String[] args)
    {
        Basic obj = new Basic();

        System.out.println(obj.x);

        obj.display();
    }

    void display()
    {
        System.out.println("Method called");
    }
}