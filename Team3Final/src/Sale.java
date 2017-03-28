
import java.io.IOException;

public class Sale {

	String productInfo = "";

	// show what do we have in the vending machine
	public void getProductCrag() throws IOException {
		System.out.println("\n1 God ---$100");
		System.out.println("2 Silver ---$50");
		System.out.println("3 iPhone ---$670");
		System.out.println("4 iPad ---$300");
		System.out.println("5 laptop ---$500");

	}

	public Product buyItem(String itemId) {

		Product product = new Product();
		return product;
	}

	public String getItemDescrip(Product product, String itemId) {

		String productInfoBuffer = product.getItem(itemId);
		return productInfoBuffer;
	}

	public double getItemOriginalPrice(Product product, String itemId, int staffQuanlity) {

		double productPrice = product.getPrice(itemId, staffQuanlity);
		return productPrice;
	}
	
	//get the price with tax
	//in the instance, we consider the machine is in France.
	public static double getTotalPrice(double productPrice) throws IOException {

		String taxAdapter = "taxAdapter";

		String taxConcret = System.getProperty(taxAdapter);

		TaxAdapter taxConcretClass = null;
		try {
			taxConcretClass = (TaxAdapter) Class.forName(taxConcret).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double totalPrice = productPrice + taxConcretClass.calculateTax(productPrice);

		return totalPrice;
	}

	public Payment createPayment() throws IOException {

		Payment payment = new Payment();

		return payment;

	}

	public boolean choosePaymentMethod(Payment payment, double totalPrice, int paymentId, String cardId)
			throws IOException {

		boolean flag = payment.choosePaymentMethod(totalPrice, paymentId, cardId);
		return flag;

	}

	public void createReceipt(String productInfo, double totalPrice, String customId) throws IOException {

		Receipt receipt = new Receipt();
		receipt.printRecipt(productInfo, totalPrice, customId);

	}

}
