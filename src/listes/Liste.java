package listes;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by bopang on 16/11/14.
 */
public class Liste<E> implements IListe<E>{

    private Maillon<E> tete;
    private ListeIterator itr;

    public Liste(){
        this.tete = null;
    }

    public Liste(Liste<E> l){
        this();
        for(E e : l){
            this.ajoute(e);
        }
//      OR
//		for(Iterator<E> it = l.iterator(); it.hasNext();){
//			this.ajoute(it.next());
//		}
    }

    @Override
    public void ajoute(E elt) throws NullPointerException {
        if (elt == null) throw new NullPointerException();
        Maillon<E> m = new Maillon<E>(elt);
        if (this.estVide()) this.tete = m;
        else {
            ListeIterator it = this.iterator();
            while (it.hasNext()) {
                it.next();
            }
            it.last.setSuivant(m);
        }
    }

    @Override
    public void insere(E elt) throws NullPointerException {
        if (elt == null) throw new NullPointerException();
        Maillon<E> m = new Maillon<E>(elt);
        if (this.estVide()) this.tete = m;
        else {
            m.setSuivant(this.tete);
            this.tete = m;
        }
    }

    private int longueur(){
        int l = 0;
        if (this.estVide()) return l;
        ListeIterator it = this.iterator();
        while (it.hasNext()){
            l++;
            it.next();
        }
        return l;
    }

    @Override
    public boolean insere(E elt, int index) throws NullPointerException{
        if (elt == null) return false;
        if(index < 0 || index > this.longueur()) return false;

        Maillon<E> m = new Maillon<E>(elt);
        if(this.estVide()||index==0){
            m.setSuivant(this.tete);
            this.tete = m;
            return true;
        }
        ListeIterator it = this.iterator();
        int i = 0;
        while (i != index){
            i++;
            it.next();
        }
        m.setSuivant(it.current);
        if(it.last != null) it.last.setSuivant(m);
        return true;
    }

    @Override
    public boolean supprime(Object elt) {
        if (elt==null||this.estVide()) {
            return false;
        }

        if (this.tete.getDonnee()==elt){
            this.tete = this.tete.getSuivant();
            return true;
        }

        ListeIterator it = this.iterator();
        while (it.hasNext()){
            if (it.next() == elt) {
                System.out.print(it.element);
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean supprimeTous(Object elt) {
        boolean flag = false;
        boolean result = true;
        while(result){
            result = this.supprime(elt);
            if (result) flag = result;
        }

        return flag;
    }

    @Override
    public void efface() {
        this.tete = null;
    }

    @Override
    public boolean estVide() {
        return this.tete == null;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Iterable)) return false;
        Iterator it1 = this.iterator();
        Iterator it2 = ((Iterable) o).iterator();
        while (true){
            if(it1.hasNext()){
                if (it2.hasNext()){
                    if(it1.next()!=it2.next()) return false;
                }
                else return false;
            }
            else {
                if (it2.hasNext()) return false;
                else break;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String s = "";
        for(E i : this){
            s = s + i + "->";
        }
        if (s.length()>2){
            s = s.substring(0,s.length()-2);
        }

        return "[" + s + "]";
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        for( E i : this )
        {
            result = result * prime + i.hashCode();
        }
        return result;
    }

    @Override
    public ListeIterator iterator() {
        return new ListeIterator();
    }

    private static class Maillon<E> {
        private E donne;
        private Maillon<E> suivant;

        public Maillon(E e){
            this.donne = e;
            this.suivant = null;
        }

        public E getDonnee(){
            return this.donne;
        }

        public void setSuivant(Maillon<E> m){
            this.suivant = m;
        }

        public Maillon<E> getSuivant(){
            return this.suivant;
        }
    }

    public class ListeIterator implements Iterator<E>{

        private Liste.Maillon<E> current;
        private E element;
        private boolean nextCalled;
        private Maillon<E> last;
        private Maillon<E> penultimate;

        public ListeIterator(){
            this.current = Liste.this.tete;
            this.last = null;
            this.penultimate = null;
            this.nextCalled = false;
            this.element = null;
        }

        @Override
        public boolean hasNext() {
            return (this.current != null);
        }

        @Override
        public E next() {
            if (!this.hasNext()) throw new NoSuchElementException();
            else {
                this.penultimate = this.last;
                this.last = this.current;
                this.current = this.current.getSuivant();
                this.element = this.last.getDonnee();
                this.nextCalled = true;
                return this.element;
            }
        }

        @Override
        public void remove() {
            if (this.nextCalled = false) {
                throw new IllegalStateException("remove : next not called yet");
            }
//            this.last.setSuivant(null);
//            this.last = this.penultimate;
//            if(this.last != null) {
//                this.last.setSuivant(this.current);
//            }
//
//            this.nextCalled = false;
            else if(this.penultimate == null){
                this.last.setSuivant(null);
                Liste.this.tete = this.current;
                this.last = null;
                this.nextCalled = false;
            }
            else {
                this.penultimate.setSuivant(this.current);
                this.last.setSuivant(null);
                this.last = this.penultimate;
                this.penultimate = null;
                this.nextCalled = false;
            }
        }

    }
}
