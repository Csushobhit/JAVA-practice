import java.util.ArrayList;

public class Order {
	private ArrayList<FoodItem> items;
	
	public Order()
	{
		items = new ArrayList<>();
	}
	public void addItems(FoodItem item)
	{
		items.add(item);
	}
	 public ArrayList<FoodItem> getItems()
	 {
	        return items;
	 }

	
	public double calculateTotalBill()
	{
		double total = 0;
		
		for(int i =0; i<items.size(); i++)
		{
			FoodItem item = items.get(i);
			double price = item.getPrice();
			double discount = item.calculateDiscount();
			total = total + (price - discount);
		}
		return total;
	}
}
