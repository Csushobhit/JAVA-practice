
public class VegFoodItem extends FoodItem{
	public VegFoodItem(String ID, String name, double price)
	{
		super(ID, name, price);
	}

	@Override
	public double calculateDiscount() {
		return (this.getPrice()*0.10);
	}
	
}
