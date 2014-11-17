package figures;
import points.Point2D;
import points.Vecteur2D;

/**
 * Created by bopang on 17/11/14.
 */
public class Cercle extends AbstractFigure{

    protected Point2D centre;
    protected double rayon;

    public Cercle(){
        this.centre = new Point2D();
        this.rayon = 0;
    }

    public Cercle(double x, double y, double r){
        this.centre = new Point2D(x, y);
        this.rayon = r;
    }

    public Cercle(Point2D p, double r){
        this.centre = new Point2D(p);
        this.rayon = r;
    }

    public Cercle(Cercle c){
        this(c.getCentre(),c.getRayon());
    }

    public void setRayon(double r){
        this.rayon = r;
    }

    @Override
    public Figure deplace(double dx, double dy) {

        this.centre.deplace(dx, dy);

        return this;
    }

    @Override
    public boolean contient(Point2D p) {
        return false;
    }

    @Override
    public Point2D getCentre() {
        return this.centre;
    }

    public double getRayon() {
        return this.rayon;
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
