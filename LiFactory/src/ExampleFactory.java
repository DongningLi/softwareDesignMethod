
public class ExampleFactory {

	public static AService aService;

	public synchronized AService getService() {
		
		if (aService == null) {
			aService = new AService();
		}

		return aService;
	}
	
}
