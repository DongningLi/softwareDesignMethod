
import java.io.IOException;

public class Payment {

	public boolean choosePaymentMethod(double totalPrice, int paymentId, String cardId) throws IOException {

		PaymentMethod paymentMethod = new PaymentMethod();

		boolean flag = false;

		switch (paymentId) {

		case 1:
			flag = paymentMethod.cash(totalPrice);
			break;
		case 2:
			flag = paymentMethod.credit(totalPrice, cardId);
			break;
		case 3:
			flag = paymentMethod.debit(totalPrice, cardId);
			break;
		default:
			flag = paymentMethod.check(totalPrice, cardId);
			break;
		}

		return flag;
	}
}
