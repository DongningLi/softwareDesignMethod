
public class Laptop extends ProductAbstract {

	double price = 500;

	public Laptop() {
		description = "laptop";
	}

	public double cost() {
		return this.price;
	}
}