package figures;
import listes.CollectionListe;
import points.Point2D;
import points.Vecteur2D;

/**
 * Created by bopang on 17/11/14.
 */
public class Groupe extends AbstractFigure{

    protected CollectionListe<Figure> figures;

    public Groupe(){
        this.figures = new CollectionListe<Figure>();
    }

    public Groupe(Iterable<Figure> l){
        this();
        for(Figure f : l){
            this.figures.add(f);
        }
    }

    public boolean add(Figure f){
        if (f==null) return false;

        this.figures.add(f);
        return true;
    }



    @Override
    public Figure deplace(double dx, double dy) {
        return null;
    }

    @Override
    public boolean contient(Point2D p) {
        return false;
    }

    @Override
    public Point2D getCentre() {
        return null;
    }

    @Override
    public double aire() {
        return 0;
    }

    @Override
    protected boolean equals(Figure f) {
        return false;
    }
}
