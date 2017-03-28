import java.io.IOException;
import java.util.Scanner;


/* ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤
❤                                                       ❤
❤   Create by Dongning Li, Chimiao Wang, Zemeng Wang    ❤
❤   CSE 5670 Software Design Method                     ❤
❤   Final Project                                       ❤
❤   11/22/2016                                          ❤
❤                                                       ❤
❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ ❤ */


public class CustomUI {

	static SystemClass newSystemClass = null;
	static Product product = null;
	static String productInfo = "";
	static double productPrice = 0;

	public static void main(String[] args) throws IOException {

		System.out.println("Please Enter your Id Number:");

		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		String customId = sc.nextLine();

		CustomInfoSystem customInfo = new CustomInfoSystem();

		//if Id in system, continue
		//else exit system
		if (customInfo.infoVerify(customId)) {

			openSystem();
			System.out.println("\nMenu is as following:");
			getProductCrag();

			System.out.println("\nPlease choose the ID number which you'd like to buy. Quit sale with 'exit'. \nComplete sale with 'complete sale'");
			
			//check if custom wants to close the sale
			String itemIdStr = sc.nextLine();
			String itemId = checkExit(itemIdStr);
			
			//while custom does NOT choose to complete, continue
			while (!itemId.equals("complete sale")) {
				
				int itemIdIntg = Integer.parseInt(itemId);
				
				//check if itemId is included in menu
				if (itemIdIntg >=1 && itemIdIntg <=5){
					Product product = buyItem(itemId);
					String productInfoBuffer = getItemDescrip(product, itemId);

					System.out.println("How many would you like to buy?");
					
					String staffQuanlityStr = sc.nextLine();
					int staffQuanlity = Integer.parseInt(checkExit(staffQuanlityStr));
					
					//get the price and information of item
					productPrice = productPrice + getItemOriginalPrice(product, itemId, staffQuanlity);
					productInfo = productInfo + staffQuanlity + " " + productInfoBuffer + "\n";

					System.out.println("\nPlease choose the ID number which you'd like to buy. Quit sale with 'exit'. \nComplete sale with 'complete sale'");
					getProductCrag();
					
					itemIdStr = sc.nextLine();
					itemId =  checkExit(itemIdStr);

				}else{
					
					/*if item Id is NOT correct*/
					
					System.out.println("\nWrong item Id, please select again.");
					getProductCrag();
					
					itemIdStr = sc.nextLine();
					itemId =  checkExit(itemIdStr);

				}
				
			}

			System.out.print("------------------------------------------------------------------------------------");

			String cardId = null;
			//flag for success of payment
			boolean flag = true;
			
			// if custom surely bought something rather than completing sale
			if (!productInfo.equals("")) {
				
				//show custom what he bought
				System.out.println("\nYou are gonna buy:");
				System.out.println(productInfo);
				
				//calculate French tax
				System.out.print("Total price with tax is: ");
				double totalPrice = getTotalPrice(productPrice);
				System.out.print(totalPrice);

				//show the payment list
				System.out.println("\n\n------------------------------------------------------------------------------------");
				System.out.println("Please choose a payment method.");
				System.out.println("1 Cash");
				System.out.println("2 Credit");
				System.out.println("3 Debit");
				System.out.println("4 Check");

				//check if custom wants to exit
				String paymentIdStr = sc.nextLine();
				int paymentId = Integer.parseInt(checkExit(paymentIdStr));

				Payment payment = createPayment();

				//if NOT pay by cash, get cardId, else use default cardId(null)
				if (paymentId != 1) {
					System.out.println("Please input your card Id.");
					
					String cardIdStr = sc.nextLine();
					cardId =  checkExit(cardIdStr);
				}
				
				flag = choosePaymentMethod(payment, productPrice, paymentId, cardId);

				//if any unknown problem occurred, system return with false
				//then get the cardId again.
				while (!flag) {

					System.out.println("\n\n------------------------------------------------------------------------------------");
					System.out.println("Payment information is wrong. Try again.");
					System.out.println("Please choose a payment method.");
					System.out.println("1 Cash");
					System.out.println("2 Credit");
					System.out.println("3 Debit");
					System.out.println("4 Check");

					paymentId = Integer.parseInt(sc.nextLine());

					if (paymentId != 1) {
												
						System.out.println("Please input your card Id.");
						String cardIdStr = sc.nextLine();
						cardId =  checkExit(cardIdStr);
					}

					flag = choosePaymentMethod(payment, productPrice, paymentId, cardId);

				}

				createReceipt(productInfo, totalPrice, customId);

				System.out.println("Have a good one.");

			} else {

				/* if productInfo equals empty, custom bought nothing,
				   quit the system directly. */

				System.out.println("\n\nYou bought nothing.");
				System.out.println("Have a good one.");

			}

		} else {

			/* Id card number is NOT authorized*/
			
			System.out.println("Information cannot be verified. System close.");
			System.exit(0);
		}

	}

	public static void openSystem() throws IOException {

		//open the system
		
		newSystemClass = new SystemClass();
		newSystemClass.createSale();
	}
	
	//detail code of checking if custom wants to exit sale
	public static String checkExit(String checkStr) {

		if(checkStr.equals("exit")){
			System.out.println("\n\nYou bought nothing.");
			System.out.println("Have a good one.");
			System.exit(0);
		}
		return checkStr;
	}

	public static void getProductCrag() throws IOException {

		newSystemClass.getProductCrag();
	}

	// choose a new product
	public static Product buyItem(String itemId) throws IOException {

		return product = newSystemClass.buyItem(itemId);
	}

	public static String getItemDescrip(Product product, String itemId) throws IOException {

		return newSystemClass.getItemDescrip(product, itemId);
	}

	public static double getItemOriginalPrice(Product product, String itemId, int staffQuanlity) throws IOException {

		return newSystemClass.getItemOriginalPrice(product, itemId, staffQuanlity);
	}

	public static double getTotalPrice(double productPrice) throws IOException {

		return newSystemClass.getTotalPrice(productPrice);
	}

	public static Payment createPayment() throws IOException {

		return SystemClass.createPayment();
	}

	public static boolean choosePaymentMethod(Payment payment, double totalPrice, int paymentId, String cardId)
			throws IOException {

		return SystemClass.choosePaymentMethod(payment, totalPrice, paymentId, cardId);
	}

	public static void createReceipt(String productInfo, double totalPrice, String customId) throws IOException {

		SystemClass.createReceipt(productInfo, totalPrice, customId);
	}

}
