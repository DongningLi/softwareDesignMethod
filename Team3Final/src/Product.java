
import java.util.Scanner;

public class Product {

	ProductAbstract product = null;

	Scanner sc = new Scanner(System.in);

	//create a new product when custom chooses
	public String getItem(String itemId) {

		switch (Integer.parseInt(itemId)) {

		case 1:
			product = new Gold();
			break;
		case 2:
			product = new Silver();
			break;
		case 3:
			product = new IPhone();
			break;
		case 4:
			product = new IPad();
			break;
		case 5:
			product = new Laptop();
			break;
		default:
			return null;
		}

		return product.getDescription();

	}

	public double getPrice(String itemId, int staffQuanlity) {

		double totalPrice = 0;

		switch (Integer.parseInt(itemId)) {

		case 1:
			product = new Gold();
			totalPrice = product.cost() * staffQuanlity;
			System.out.println("You will buy more " + staffQuanlity + " Gold");
			break;
		case 2:
			product = new Silver();
			totalPrice = product.cost() * staffQuanlity;
			System.out.println("You will buy more " + staffQuanlity + " Silver");
			break;
		case 3:
			product = new IPhone();
			totalPrice = product.cost() * staffQuanlity;
			System.out.println("You will buy more " + staffQuanlity + " iPhone");
			break;
		case 4:
			product = new IPad();
			totalPrice = product.cost() * staffQuanlity;
			System.out.println("You will buy more " + staffQuanlity + " iPad");
			break;
		case 5:
			product = new Laptop();
			totalPrice = product.cost() * staffQuanlity;
			System.out.println("You will buy more " + staffQuanlity + " laptop");
			break;
		default:
			return 0;
		}
		return totalPrice;
	}
}