package listes;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by bopang on 15/10/14.
 */
public class CollectionListe<E> extends AbstractCollection<E>{

    private Liste<E> liste;

    public CollectionListe(){
        this.liste = new Liste<E>();
    }

    public CollectionListe(Collection<E> coListe){
        this.liste = new Liste<E>();
        for(E i : coListe){
            this.liste.ajoute(i);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return this.liste.iterator();
    }

    @Override
    public int size() {
        return this.liste.longueur();
    }

    @Override
    public boolean add(E elt){
        if (elt==null) return false;

        this.liste.ajoute(elt);
        return true;
    }

    @Override
    public boolean equals(Object o){
        return this.liste.equals(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public int hashCode(){
        return this.liste.hashCode();
    }
}
