import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<FoodItem> menu = new ArrayList<>();
        Order order = new Order();
        int choice = 0;
        do
        {
            try
            {
                System.out.println("\n1. Create Veg Item");
                System.out.println("2. Create Non Veg Item");
                System.out.println("3. Show Menu");
                System.out.println("4. Order Item");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine();


                switch(choice)
                {

                    case 1:

                        System.out.print("Enter ID: ");
                        String vid = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String vname = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double vprice = sc.nextDouble();
                        sc.nextLine();
                        menu.add(new VegFoodItem(vid, vname, vprice));
                        System.out.println("Veg Item Added");
                        break;
                    case 2:
                        System.out.print("Enter ID: ");
                        String nvid = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String nvname = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double nvprice = sc.nextDouble();
                        sc.nextLine();
                        menu.add(new NonVegFoodItem(nvid, nvname, nvprice));
                        System.out.println("Non Veg Item Added");
                        break;
                    case 3:
                        System.out.println("\nMENU:");
                        for(int i=0;i<menu.size();i++)
                        {
                            FoodItem item = menu.get(i);
                            System.out.println(item.getId()+" "+item.getName()+" "+item.getPrice());
                        }
                        break;
                    case 4:
                        String id;
                        do
                        {
                            System.out.print("Enter Item ID: ");
                            id = sc.nextLine();
                            if(id.equals("0"))
                            break;
                            boolean f = false;
                            for(int i=0;i<menu.size();i++)
                            {
                                FoodItem item = menu.get(i);
                                if(item.getId().equals(id))
                                {
                                    order.addItems(item);
                                    System.out.println("Added");
                                    f = true;
                                }
                            }
                            if(!f)
                            System.out.println("Item not found");


                        }while(true);



                        double total = 0;

                        System.out.println("\nBILL:");

                        for(int i=0;i<order.getItems().size();i++)
                        {
                            FoodItem item = order.getItems().get(i);
                            double price = item.getPrice();
                            double discount = item.calculateDiscount();
                            double finalPrice = price - discount;
                            total += finalPrice;
                            System.out.println(item.getName()+" Price:"+price+" Discount:"+discount+" Final:"+finalPrice);
                        }
                        System.out.println("\nTOTAL BILL = " + total);
                        break;
                    case 5:
                        System.out.println("Thank You");

                        break;
                    default:
                        System.out.println("Wrong Input");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Input (Enter number only)");
                sc.nextLine();
            }
        }while(choice!=5);
    }
}