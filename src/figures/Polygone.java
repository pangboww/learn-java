package figures;
import listes.CollectionListe;
import points.Point2D;
import points.Vecteur2D;


/**
 * Created by bopang on 17/11/14.
 */
public class Polygone extends AbstractFigure{

    protected CollectionListe<Point2D> listePoints;

    public Polygone(){
        this.listePoints = new CollectionListe<Point2D>();
    }

    public Polygone(Point2D p){
        this();
        this.listePoints.add(p);
    }

    public Polygone(Point2D p1, Point2D p2){
        this();
        this.listePoints.add(p1);
        this.listePoints.add(p2);
    }

    public Polygone(Iterable<Point2D> l){
        this();
        for(Point2D point : l){
            this.listePoints.add(point);
        }
    }

    public CollectionListe<Point2D> getListePoints(){
        return this.listePoints;
    }

    @Override
    public Figure deplace(double dx, double dy) {
        for(Point2D p : this.listePoints){
            p.deplace(dx, dy);
        }
        return this;
    }

    @Override
    public boolean contient(Point2D p) {
        return false;
    }

    @Override
    public Point2D getCentre() {
        double sumx = 0;
        double sumy = 0;
        for(Point2D p : this.listePoints){
            sumx += p.getX();
            sumy += p.getY();
        }
        int nombre = this.listePoints.size();
        Point2D centre = new Point2D(sumx / nombre, sumy / nombre);
        return centre;
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

