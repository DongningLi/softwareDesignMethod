
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*check cardInfo with file 'cardInfo.txt'.
 return true when pay by cash. */

public class PaymentMethod {

	public boolean cash(double totalPrice) {

		return true;
	}

	public boolean credit(double totalPrice, String cardId) throws IOException {

		//read information from file
		File file = new File("cardInfo.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);

		//while file does NOT come to end, compare with cardInfo inputed
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.equals(cardId)) {
				return true;
			}
		}

		br.close();

		return false;

	}

	public boolean debit(double totalPrice, String cardId) throws IOException {

		File file = new File("cardInfo.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);

		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.equals(cardId)) {
				return true;
			}
		}

		br.close();

		return false;

	}

	public boolean check(double totalPrice, String cardId) throws IOException {

		File file = new File("cardInfo.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);

		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.equals(cardId)) {
				return true;
			}
		}

		br.close();

		return false;

	}
}
