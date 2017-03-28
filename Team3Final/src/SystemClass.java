
import java.io.IOException;

public class SystemClass {

	static Sale newSale = null;

	public void createSale() throws IOException {

		newSale = new Sale();
	}

	public void getProductCrag() throws IOException {

		newSale.getProductCrag();
	}

	//custom chooses a new product
	public Product buyItem(String itemId) throws IOException {

		Product product = newSale.buyItem(itemId);
		return product;
	}

	public String getItemDescrip(Product product, String itemId) throws IOException {

		return newSale.getItemDescrip(product, itemId);
	}

	public double getItemOriginalPrice(Product product, String itemId, int staffQuanlity) throws IOException {

		return newSale.getItemOriginalPrice(product, itemId, staffQuanlity);
	}

	public static double getTotalPrice(double productPrice) throws IOException {

		return newSale.getTotalPrice(productPrice);
	}

	public static Payment createPayment() throws IOException {

		return newSale.createPayment();
	}

	public static boolean choosePaymentMethod(Payment payment, double totalPrice, int paymentId, String cardId)
			throws IOException {

		return newSale.choosePaymentMethod(payment, totalPrice, paymentId, cardId);
	}

	public static void createReceipt(String productInfo, double totalPrice, String customId) throws IOException {

		newSale.createReceipt(productInfo, totalPrice, customId);
	}

}
