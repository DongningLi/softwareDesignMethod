import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CondimentFactory {

	public static CondimentFactory cInstance;

	public static synchronized CondimentFactory getInstance() {

		if (cInstance == null) {
			cInstance = new CondimentFactory();
		}

		return cInstance;
	}

	public static synchronized Beverage getBeverage(String condimentName)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		return (Beverage) Class.forName(condimentName).newInstance();

	}

	public static synchronized Beverage getCondiment(String condimentName, Beverage beverage)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Constructor<?> c = Class.forName(condimentName).getConstructor(Beverage.class);
		return (Beverage) c.newInstance(beverage);
	}

}
