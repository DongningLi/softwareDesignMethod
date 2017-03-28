
public class Gold extends ProductAbstract {

	double price = 100;

	public Gold() {
		description = "Gold";
	}

	public double cost() {
		return this.price;
	}
}