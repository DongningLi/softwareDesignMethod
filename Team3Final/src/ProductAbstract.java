
public abstract class ProductAbstract {
	
	//for each product, detail contains its description and price.

	String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
