package figures;
import listes.CollectionListe;
import points.Point2D;
import points.Vecteur2D;
/**
 * Created by bopang on 17/11/14.
 */
public class Rectangle extends AbstractFigure  {
    protected Point2D pmin;
    protected Point2D pmax;

    protected double minimum(double v1, double v2){
        return v1 < v2 ? v1 : v2;
    }

    protected double maximum(double v1, double v2){
        return v1 > v2 ? v1 : v2;
    }

    public Rectangle(){
        this.pmin = new Point2D();
        this.pmax = new Point2D();
    }

    public Rectangle(double x1, double y1, double x2, double y2){
        this.pmin = new Point2D(x1, y1);
        this.pmax = new Point2D(x2, y2);
    }

    public Rectangle(Point2D p1, Point2D p2){
        this.pmin = new Point2D(p1);
        this.pmax = new Point2D(p2);
    }

    public Rectangle(Rectangle r){
        this(r.getPmin(),r.getPmax());
    }

    public Point2D getPmin(){
        return this.pmin;
    }
    public Point2D getPmax(){
        return this.pmax;
    }

    public double hauteur(){
        return this.pmax.getY()-this.pmax.getY();
    }

    public double largeur(){
        return this.pmax.getX()-this.pmax.getX();
    }

    @Override
    public Figure deplace(double dx, double dy) {
        this.pmax.deplace(dx, dy);
        this.pmin.deplace(dx, dy);
        return this;
    }

    @Override
    public boolean contient(Point2D p) {
        return (this.pmin.equals(p)
                || this.pmax.equals(p));
    }

    @Override
    public Point2D getCentre() {
        double x = (this.pmin.getX() + this.pmax.getX()) / 2;
        double y = (this.pmin.getY() + this.pmax.getY()) / 2;
        Point2D centre = new Point2D(x, y);
        return centre;
    }

    @Override
    public double aire() {
        return this.largeur() * this.hauteur();
    }

    @Override
    protected boolean equals(Figure f) {
        if (!getClass().equals(f.getClass())) return false;
        Rectangle other = (Rectangle) f;
        return (this.pmin.equals(other.pmin)
                && this.pmax.equals(other.pmax));
    }
}
