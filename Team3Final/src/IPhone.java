
public class IPhone extends ProductAbstract {

	double price = 670;

	public IPhone() {
		description = "iPhone";
	}

	public double cost() {
		return this.price;
	}
}