package figures;
import points.Point2D;

/**
 * Classe abstraite Figure Contient une données concrête : le nom de la figure (
 * {@link #nom} )
 * <ul>
 * <li>des méthodes d'instance</li>
 * <ul>
 * <li>concrètes
 * <ul>
 * <li>un constructeur avec un nom : {@link #AbstractFigure(String)}</li>
 * <li>un accesseur pour ce nom : {@link #getNom()}</li>
 * <li>la méthode toString pour afficher ce nom {@link #toString()}</li>
 * <li> {@link #distanceToCentreOf(Figure)}</li>
 * </ul>
 * <li>abstraites
 * <ul>
 * <li> {@link #deplace(double,double)}</li>
 * <li> {@link #contient(Point2D)}</li>
 * <li> {@link #getCentre()}</li>
 * <li> {@link #aire()}</li>
 * </ul>
 * </ul>
 * <li>des méthodes de classes</li>
 * <ul>
 * <li>concrètes</li>
 * <ul>
 * <li> {@link #distanceToCentre(Figure,Figure)}</li>
 * </ul>
 * </ul> </ul>
 *
 * @author David Roussel
 */
public abstract class AbstractFigure implements Figure
{
	/**
     * Nom de la figure
     */
	protected String nom;

	/**
	 * Constructeur (protégé) par défaut.
	 * Affecte le nom de la classe comme nom de figure
	 */
	protected AbstractFigure()
	{
		nom = getClass().getSimpleName();
	}

	/**
	 * Constructeur (protégé) avec un nom
	 * on a fait exprès de ne pas mettre de constructeur sans arguments
	 * @param unNom Chaine de caractère pour initialiser le nom de la
	 * figure
	 */
	protected AbstractFigure(String unNom)
	{
		nom = unNom;
	}

	/**
     * @return le nom
     * @see figures.Figure#getNom()
     */
	@Override
	public String getNom()
	{
		return nom;
	}

	/* (non-Javadoc)
	 * @see figures.Figure#deplace(double, double)
	 */
	@Override
	public abstract Figure deplace(double dx, double dy);

	/* (non-Javadoc)
	 * @see figures.Figure#toString()
	 */
	@Override
	public String toString()
	{
		return(nom + " : ");
	}

	/* (non-Javadoc)
	 * @see figures.Figure#contient(points.Point2D)
	 */
	@Override
	public abstract boolean contient(Point2D p);

	/* (non-Javadoc)
	 * @see figures.Figure#getCentre()
	 */
	@Override
	public abstract Point2D getCentre();

	/* (non-Javadoc)
	 * @see figures.Figure#aire()
	 */
	@Override
	public abstract double aire();

	// Quelles que soient les figures il s'agit du même principe
	// donc ces méthodes sont CONCRETES !!!
	/**
	 * Distance entre les centres de deux figures
	 * @param f1 première figure
	 * @param f2 seconde figure
	 * @return la distance entre les points centraux des deux figures
	 * @see #getCentre()
	 * @see Point2D#distance(Point2D, Point2D)
	 */
	public static double distanceToCentre(Figure f1, Figure f2)
	{
		// getCentre est une méthode abstraite mais rien ne nous empêche
		// de l'utiliser dans une autre méthode. Grâce au lien dynamique
		// TODO remplacer par l'implémentation
		return 0.0;
	}

	/* (non-Javadoc)
	 * @see figures.Figure#distanceToCentreOf(figures.Figure)
	 */
	@Override
	public double distanceToCentreOf(Figure f)
	{
		// TODO remplacer par l'implémentation
		return 0.0;
	}

	/**
	 * Comparaison de deux figures en termes de contenu
	 * @return true si f est du même types que la figure courante et qu'elles
	 * ont un contenu identique
	 */
	protected abstract boolean equals(Figure f);

	/**
	 * Comparaison de deux figures, on ne peut pas vérifier grand chose pour
	 * l'instant à part la classe et le nom
	 * @note implémentation partielle qui ne vérifie que null/this/et l'égalité
	 * de classe
	 * @see figures.Figure#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (this == obj)
		{
			return true;
		}
		if (obj instanceof Figure)
		{
			return equals((Figure) obj);
		}
		else
		{
			return false;
		}
	}
}