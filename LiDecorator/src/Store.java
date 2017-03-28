import java.lang.reflect.InvocationTargetException;

/*
 * Create by Professor Bond
 * Edit by Dongning Li(Donnie)
 * Pattern Assignment 2
 * Problem 1
 */

public class Store {

	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {

		CondimentFactory cf = CondimentFactory.getInstance();
		Register registerObj = new Register(cf);
	}

}
