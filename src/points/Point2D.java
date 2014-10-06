package points;

public class Point2D {
    protected double x;
    protected double y;
    protected static int nbPoints=0;

    public Point2D() {
        super();
        this.x = 0;
        this.y = 0;
        Point2D.nbPoints++;
    }

    public Point2D(double x, double y){
        super();
        this.x = x;
        this.y = y;
        Point2D.nbPoints++;
    }

    public Point2D (Point2D p){
        super();
        this.x = p.getX();
        this.y = p.getY();
        Point2D.nbPoints++;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void deplace(double deltaX, double deltaY){
        this.x += deltaX;
        this.y += deltaY;
    }

    public String toString() {
        return "x = " + this.x + " y = " + this.y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double distance(Point2D p){
        return Math.sqrt((p.getX()- this.x)*(p.getX()- this.x)+(p.getY()- this.y)*(p.getY()- this.y));
    }

    public static double distance(Point2D a,Point2D b){
        return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX())+(a.getY()-b.getY())*(a.getY()-b.getY()));
    }

    public boolean equals(Point2D p){
        return (this.distance(p) <= Point2D.getEpsilon());
    }

    public static double getEpsilon(){
        return 1e-6;
    }

    public static int getNbPoints(){
        return Point2D.nbPoints;
    }



    protected void finalize(){
        Point2D.nbPoints--;
    }



}