
public abstract class FoodItem {
	private String Id;
	private String name;
	private double price;
	
	public FoodItem(String ID, String name, double price)
	{
		this.Id = ID;
		this.name = name;
		this.price = price;
	}
	abstract public double calculateDiscount();
	public double getPrice() {
		return price;
	}
	public String getId()
    {
        return Id;
    }

    public String getName()
    {
        return name;
    }

}
