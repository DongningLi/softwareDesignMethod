
public class Sprinkles extends CondimentDecorator {

	Beverage beverage;

	public Sprinkles(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Sprinkles";
	}

	public double cost() {
		return .17 + beverage.cost();
	}

}
