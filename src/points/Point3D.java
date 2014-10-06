package points;

public class Point3D extends Point2D {

    protected double z;

    public Point3D(){
        super();
        this.z = 0;
    }

    public Point3D(double x, double y, double z){
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        Point3D.nbPoints++;
    }

    public Point3D (Point3D p){
        super();
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
        Point2D.nbPoints++;
    }

    public Point3D (Point2D p){
        super();
        this.x = p.getX();
        this.y = p.getY();
        this.z = 0;
        Point2D.nbPoints++;
    }

    public void setZ(double z){
        this.z = z;
    }

    public Point3D deplace(double deltaX, double deltaY, double deltaZ){
        this.x += deltaX;
        this.y += deltaY;
        this.z += deltaZ;
        return this;
    }

    public String toString() {
        return "x = " + this.x + " y = " + this.y +  " z = " + this.z;
    }

    public double getZ(){
        return this.z;
    }


    public double distance(Point3D p){
        double d = Math.sqrt((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y)+(p.z-this.z)*(p.z-this.z));
        return d;
    }

    public static double distance(Point3D a,Point3D b){
        double d = Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)+(a.z-b.z)*(a.z-b.z));
        return d;
    }

    public boolean equals(Point3D p){
        return this.distance(p)<Point3D.getEpsilon();
    }

    public boolean equals(Point2D p){
        if (this.getZ() == 0) return this.equals(new Point3D(p.getX(),p.getY(),0));
        else return false;
    }
}
