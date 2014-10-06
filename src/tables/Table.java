package tables;
/**
 * Classe table utilisée pour produire une implémentation alternative d'une pile.
 * La classe table contient un tableau d'objet qui peut servir de conteneur à une
 * pile.
 * On ne fait pas cette classe en TD, on se contente de l'utiliser en considérant
 * qu'elle est déjà implémentée.
 * @author David Roussel
 */
public class Table
{
	/**
	 * La table d'objets
	 */
	private Object[] table;
	/**
	 * Le nombre de cases maximal de la table
	 */
	private int nbCases;

	/**
	 * Constructeur valué.
	 * Construit une table d'objets de nCases.
	 * @param nbCases nombres de cases de la table d'objets.
	 */
	public Table (int nbCases)
	{
		System.err.println("\tTable::Table(" + nbCases + ")");
		table = new Object[nbCases];
		this.nbCases = nbCases;
		// on ne remplit pas les cases car elles seront
		// remplies par les objetsp.getZ() que l'on va y ajouter
	}

	/**
	 * Obtention de l'objet à la case i
	 * @param i l'index de la case de l'objet
	 * @return l'objet contenu à la case d'index i, ou bien null si la case
	 * d'index i n'existe pas.
	 */
	public Object getValAt (int i)
	{
//		System.err.print("\tTable::getValAt(" + i + ") : ");

		if ( (i < nbCases) && (i >= 0) )
		{
//			System.err.println("ok");
			return table[i];
		}
		else
		{
			System.err.println("index en dehors des bornes ");
			return null;
		}
	}

	/**
	 * Mise en place de l'objet o à la case i.
	 * Si l'index de la case i est invalide : aucun objet n'est ajouté
	 * @param i l'index de la case de la table où placer l'objet o.
	 * @param o l'objet o dont on va copier la référence dans la case d'index i.
	 */
	public void setValAt (int i, Object o)
	{
//		System.out.print("\tTable::setValAt(" + i + ") : ");

		if ((i < nbCases) && (i >= 0))
		{
//			System.err.println("ok");
			table[i] = o;
		}
		else
		{
			System.err.println("index en dehors des bornes ");
		}
	}

	/**
	 * Nombre de cases possible dans la table
	 * @return nombres de cases max de la table
	 */
	public int size()
	{
		return nbCases;
	}
}
