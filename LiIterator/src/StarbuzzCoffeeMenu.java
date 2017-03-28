import java.util.Hashtable;

public class StarbuzzCoffeeMenu implements Menu  {

	Hashtable<Integer, MenuItem> menuItems;
  
	public StarbuzzCoffeeMenu() {
		menuItems = new Hashtable<Integer, MenuItem>();
 
		addItem("House Blend", "House Blend Coffee", true, .89);
		addItem("Dark Roast", "Dark Roast Coffee", true, .99);
		addItem("Decaf", "Decaf Coffee", true, 1.05);
		addItem("Espresso", "Espresso", true, 1.99);
		addItem("Steamed Milk", "Steamed Milk", true,.10);
		addItem("Mocha", "Mocha", true, .20);
		addItem("Soy", "Soy", true, .15);
		addItem("Whip", "Whip", true, .10);
	}
  
	public void addItem(String name,String description,
            boolean vegetarian, double price) 
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItems.size(),menuItem);
	}
 
	public Hashtable<Integer, MenuItem> getMenuItems() {
		return menuItems;
	}
  
	public Iterator createIterator() {
		return new StarbuzzMenuIterator(menuItems);
	}
 
	// other menu methods here
}
