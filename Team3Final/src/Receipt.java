
public class Receipt {

	public void printRecipt(String productInfo, double productPrice, String customId) {

		System.out.println("\n\n------------------------------------------------------------------------------------");
		System.out.println("Here is your receipt.");
		System.out.println("\nCustom Id is: " + customId + "\n");
		System.out.println("You bought:");
		System.out.println(productInfo);
		System.out.println("Total price is: $" + productPrice + "\n");
	}
}
