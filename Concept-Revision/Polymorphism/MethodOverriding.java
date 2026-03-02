class Animal
{
    void sound()
    {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal
{
    void sound()
    {
        System.out.println("Dog barks");
    }
}

class Test
{
    public static void main(String[] args)
    {
        Animal a = new Dog();

        a.sound();
    }
}