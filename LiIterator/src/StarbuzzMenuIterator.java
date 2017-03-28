import java.util.Hashtable;

public class StarbuzzMenuIterator implements Iterator {
	
	Hashtable<Integer, MenuItem> menuItems;
	int position = 0;
 
	public StarbuzzMenuIterator(Hashtable<Integer, MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
 
	public Object next() {
		MenuItem menuItem = menuItems.get(position);
		position = position + 1;
		return menuItem;
	}
 
	public boolean hasNext() {
		if (position >= menuItems.size() || menuItems.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
