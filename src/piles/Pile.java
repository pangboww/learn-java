package piles;

/**
 * L'interface pile définit les méthodes utilisées dans une pile.
 * Les méthodes spécifiées ci-dessous sont (à peu près) celles de la classe
 * Stack présente dans le JDK
 *
 * @author David Roussel
 */
public interface Pile
{
	/**
	 * Teste si la pile est vide
	 *
	 * @return true si la pile est vide, false sinon.
	 */
	public boolean empty();

	/**
	 * Teste si la pile est pleine
	 *
	 * @return true si la pile est pleine, false sinon.
	 */
	public boolean full();

	/**
	 * Empile un objet dans la pile. On se contentera d'empiler ici la référence
	 * de l'objet: shallow copy. Mais on aurai pu empiler une copie de l'objet:
	 * deep copy. Si la pile est pleine l'objet n'est pas empilé.
	 *
	 * @param o l'objet à empiler dans la pile
	 * @return true si l'on a réussi à empiler l'élément, false sinon
	 */
	public boolean push(Object o);

	/**
	 * dépilage du dernier objet empilé.
	 *
	 * @return l'objet dépilé, ou bien null si la pile est vide.
	 */
	public Object pop();

	/**
	 * Récupère l'élément en haut de la pile sans le dépiler
	 *
	 * @return une référence vers l'objet en haut de la pile ou bien null si la
	 *         pile est vide
	 * @post une référence vers l'objet en haut de la pile est renvoyée mais
	 *       celui ci n'est pas dépilé
	 */
	public Object peek();

	/**
	 * Recherche l'objet passé en argument dans la pile et renvoie sa distance
	 * par rapport au haut de la pile. le haut de la pile étant considéré comme
	 * étant à une distance 1 : Cela permet de déterminer le nombre de pops
	 * nécessaires à l'obtention de l'élément recherché.
	 *
	 * @param o l'objet à rechercher dans la pile
	 * @return la distance de l'objet (en commençant par 1) de l'objet par
	 *         rapport au sommet de la pile, ou bien -1 si l'objet n'est pas
	 *         dans la pile
	 */
	public int search(Object o);

	/**
	 * Nombre d'éléments actuellement dans la pile
	 * @return le nombre d'éléments empilés dans la pile.
	 */
	public int size();

	/**
	 * Test d'égalité au sens du contenu avec une autre pile
	 * @return true si o est une pile et que son contenu est identique
	 * @warning tester le contenu requiert de dépiler les éléments, il sera
	 * donc nécessaire de créer des piles temporaires
	 */
	@Override
	boolean equals(Object o);

	/**
	 * Hash code d'une pile basée sur la somme des hashCode de chacun des
	 * éléments dépilé en multipliant le hashCode obtenu jusqu'ici par 31
	 * @return le hashcode de la pile
	 * {@code
	 * 	final int prime = 31;
	 * 	int hash = 1;
	 * 	Pile p = <Create a copy of the current PileXXX>
	 * 	while(!p.empty())
	 * 	{
	 * 		Object elt = p.pop();
	 * 		hash = (prime * hash) + (elt == null ? 0 : elt.hashCode());
	 * 	}
	 * 	return hash;
	 * }
	 */
	@Override
	int hashCode();


	/**
	 * Représentation de la pile sous forme de chaîne de caractères
	 * @return une chaine de caractères représentant la pile
	 */
	@Override
	public String toString();
}
