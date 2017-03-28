import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Register {

	public Register(CondimentFactory cf) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		System.out.println("Please enter your new sale.");

		Beverage beverage = null;

		Scanner sc = new Scanner(System.in);
		String condimentName = sc.nextLine().toLowerCase();
		if (condimentName.equals("new sale")) {

			System.out.println("Please enter your beverage first.(Case Sensitive)");
			condimentName = sc.nextLine();
			if (!condimentName.equals("end sale")) {
				beverage = CondimentFactory.getBeverage(condimentName);

				System.out.println("Please enter your condiments.(Case Sensitive)");
				condimentName = sc.nextLine();
				while (!condimentName.equals("end sale")) {

					beverage = CondimentFactory.getCondiment(condimentName, beverage);
					condimentName = sc.nextLine();
				}

			}

		}

		if (beverage != null) {
			System.out.println("\nHere is your order and price:");
			System.out.println(beverage.getDescription() + " $" + beverage.cost());
			System.out.println("Have a good one.");
		} else {
			System.out.println("You order nothing.");
			System.out.println("Have a good one.");
		}

	}
}
