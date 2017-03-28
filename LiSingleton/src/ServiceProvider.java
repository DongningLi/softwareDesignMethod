/*
 * Create by Dongning Li(Donnie)
 * Pattern Assignment 1
 * Problem 1
 */
public class ServiceProvider {
	
	public static ServiceProvider instance;

	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++){
			ServiceProvider.getInstance();
		}
		
	}
		
	public static synchronized ServiceProvider getInstance(){
		
		if(instance == null){
			System.out.println("Constructing ServiceProvider");
			instance = new ServiceProvider();
		}else{
			System.out.println("ServiceProvider already exists");
		}
		
		return instance;
	}

}
