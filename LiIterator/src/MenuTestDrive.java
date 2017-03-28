import java.util.*;

public class MenuTestDrive {
	public static void main(String args[]) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        StarbuzzCoffeeMenu starbuzzCoffeeMenu = new StarbuzzCoffeeMenu();
 
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, starbuzzCoffeeMenu);
 
		waitress.printMenu();
	}

	public static void printMenu() {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		StarbuzzCoffeeMenu starbuzzCoffeeMenu = new StarbuzzCoffeeMenu();

		ArrayList breakfastItems = pancakeHouseMenu.getMenuItems();
		
		for (int i = 0; i < breakfastItems.size(); i++) {
			MenuItem menuItem = (MenuItem)breakfastItems.get(i);
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}

		MenuItem[] lunchItems = dinerMenu.getMenuItems();
 
		for (int i = 0; i < lunchItems.length; i++) {
			MenuItem menuItem = lunchItems[i];
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}
		
		
		Hashtable<Integer, MenuItem> beveragetItems = starbuzzCoffeeMenu.getMenuItems();
		 
		for (int i = 0; i < beveragetItems.size(); i++) {
			MenuItem menuItem = beveragetItems.get(i);
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}
	}
}
