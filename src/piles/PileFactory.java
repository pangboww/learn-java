package piles;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Factory permettant de créer différents types de piles utilisées dans les
 * tests
 * @author davidroussel
 */
public class PileFactory
{
	/**
	 * Obtention d'une nouvelle pile d'après le type de pile souhaité et
	 * éventuellement une autre pile dont il faudra copier le contenu dans
	 * la nouvelle pile.
	 * @param typePile type de pile (PileVector ou PileTable)
	 * @param other une autre pile dont il faut copier le contenu à moins
	 * que cet argument soit null
	 * @return une nouvelle pile du type souhaité, vide si other est null
	 * et remplie avec le contenu de other si celui ci est non null
	 * @throws NoSuchMethodException Si le constructeur demandé n'existe pas
	 * @throws SecurityException Si le security manager n'autorise pas l'accès
	 * au constructeur demandé.
	 * @throws InvocationTargetException Si le constructeur invoqué déclenche
	 * une exception
	 * @throws IllegalAccessException Si le constructeur demandé est inaccessible
	 * @throws InstantiationException Si la classe demandée n'est pas
	 * instanciable (abstraite)
	 * @throws IllegalArgumentException Si le constructeur invoqué ne supporte
	 * pas les arguments fournis
	 */
	public static Pile getPile(Class<? extends Pile> typePile,
	                           Pile other)
			throws SecurityException, NoSuchMethodException,
				IllegalArgumentException, InstantiationException,
				IllegalAccessException, InvocationTargetException
	{
		Constructor<? extends Pile> constructor = null;
		Class<?>[] argumentsTypes = null;
		Object[] arguments = null;
		Object instance = null;

		if (other != null)
		{
			argumentsTypes = new Class<?>[1];
			argumentsTypes[0] = Pile.class;
			arguments = new Object[1];
			arguments[0] = other;
		}
		else
		{
			argumentsTypes = new Class<?>[0];
			arguments = new Object[0];
		}

		constructor = typePile.getConstructor(argumentsTypes);

		if (constructor != null)
		{
			instance = constructor.newInstance(arguments);
		}

		return (Pile)instance;
	}
}
