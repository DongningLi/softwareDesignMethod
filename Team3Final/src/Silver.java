
public class Silver extends ProductAbstract {

	double price = 50;

	public Silver() {
		description = "Silver";
	}

	public double cost() {
		return this.price;
	}
}