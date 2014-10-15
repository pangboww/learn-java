package lists;

import java.util.Iterator;

public interface IListe<E> extends Iterable<E> {
	
	public boolean ajoute(E e);
	public void efface();
	public boolean equals(Object o);
	public boolean estVide();
	public int hashCode();
	public boolean insere(E e);
	public boolean insere(E e, int index);
	public Iterator<E> iterator();
	public boolean supprime(E e);
	public boolean supprimeTous(E e);
	public String toString();
	
}

