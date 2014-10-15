package lists;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class Liste<E> implements IListe<E> {

    private Maillon<E> tete;

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
    public ListeIterator iterator() {
        return new ListeIterator();
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
    public boolean ajoute(E e) {
        Maillon<E> m = new Maillon<E>(e);
        if(this.estVide()) this.tete = m;
        else {
            ListeIterator it = this.iterator();
            while (it.hasNext()) {
                it.next();
            }
            it.last.setSuivant(m);
        }
        return true;
    }

    @Override
    public boolean insere(E e) {
        Maillon<E> m = new Maillon<E>(e);
        if (this.estVide()) this.tete = m;
        else {
            m.setSuivant(this.tete);
            this.tete = m;
            return true;
        }
        return true;
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
    public boolean insere(E e, int index) {
        Maillon<E> m = new Maillon<E>(e);
        if(index < 0 || index > this.longueur()) return false;
        ListeIterator it = this.iterator();
        int i = 0;
        while (i != index){
            i++;
            it.next();
        }
        m.setSuivant(it.current);
        it.last.setSuivant(m);
        return true;
    }

    @Override
    public boolean supprime(E e) {
        ListeIterator it = this.iterator();
        while (it.hasNext()){
            if (it.element == e) {
                it.next();
                it.remove();
                return true;
            }
            else it.next();
        }
        return false;
    }

    @Override
    public boolean supprimeTous(E e) {
        ListeIterator it = this.iterator();
        while (it.hasNext()){
            if (it.element == e) {
                it.next();
                it.remove();
            }
            else it.next();
        }
        return true;
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

    private class ListeIterator implements Iterator<E>{

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
            if (this.current == null){
                this.element = null;
            }
            else {
                this.element = this.current.donne;
            }


        }

        @Override
        public boolean hasNext() {
            return this.current.suivant != null;
        }

        @Override
        public E next() {
            if (!this.hasNext()) return null;
            else {
                this.penultimate = this.last;
                this.last = this.current;
                this.current = this.current.getSuivant();
                this.element = this.current.donne;
                this.nextCalled = true;
                return this.element;
            }
        }

        @Override
        public void remove() {
            if (this.nextCalled = false) {
                throw new IllegalStateException("remove : next not called yet");
            }
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

