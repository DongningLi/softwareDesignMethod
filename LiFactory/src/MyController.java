/*
 * Create by Dongning Li(Donnie)
 * Pattern Assignment 1
 * Problem 2
 */
public class MyController {

	public static ExampleFactory instance;

	public static void main(String[] args) {

		MyController.getInstance();
		AService aService = instance.getService();
		aService.ProvideService();
	}

	public static synchronized ExampleFactory getInstance() {

		if (instance == null) {
			instance = new ExampleFactory();
		}

		return instance;
	}
}
