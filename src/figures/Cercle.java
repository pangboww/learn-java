package figures;
import points.Point2D;

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
        return this.centre.equals(p);
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
        return Math.PI*this.rayon*this.rayon;
    }

    @Override
    protected boolean equals(Figure f) {
        if (!getClass().equals(f.getClass())) return false;
        Cercle other = (Cercle) f;
        return (this.centre.equals(other.getCentre())
                && this.rayon == other.getRayon());
    }

    @Override
    public String toString(){
        double x = this.centre.getX();
        double y = this.centre.getY();
        double r = this.getRayon();
        String result = String.format("Cercle : x = %2.1f y = %2.1f, r = %2.1f",x, y ,r);
        return result;
    }
}
