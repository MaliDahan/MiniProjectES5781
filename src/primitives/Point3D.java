package primitives;

/**
 * Basic geometric object (point) for Ray tracing in 3D
 * @outhor Mali
 * @author Routy
 */
public class Point3D {
    final Coordinate _x;
    final Coordinate _y;
    final Coordinate _z;

    public final static Point3D PointZERO=new Point3D(0,0,0);

    /**
     *
     * @param x coordinate for x axis
     * @param y coordinate for y axis
     * @param z coordinate for z axis
     */

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this(x._coord,y._coord, z._coord);
    }

    public Point3D(double x, double y, double z) {
        _x = new Coordinate(x);
        _y = new Coordinate(y);
        _z = new Coordinate(z);
    }

    public Point3D(Point3D p) {
        _x = new Coordinate(p._x._coord);
        _y = new Coordinate(p._y._coord);
        _z = new Coordinate(p._z._coord);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) && _y.equals(point3D._y) && _z.equals(point3D._z);
    }

    @Override
    public String toString(){
        return "(" + _x + "," + _y + "," + _z + ")";
    }

    /**
     *
     * @param
     * @return
     */

    public double distanceSquared(Point3D other){
        final double x1=_x._coord;
        final double y1=_y._coord;
        final double z1=_z._coord;

        final double x2= other._x._coord;
        final double y2= other._y._coord;
        final double z2= other._z._coord;

        return (((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))+((z2-z1)*(z2-z1)));
    }

    /**
     * @param point3D
     * @return
     */

    public double distance(Point3D point3D){
        return Math.sqrt(distanceSquared(point3D));
    }

    public Point3D add(Vector vector){
        return new Point3D(
                _x._coord +vector._head._x._coord,
                _y._coord +vector._head._y._coord,
                _z._coord +vector._head._z._coord);
    }

    public Vector subtract(Point3D p){
        return new Vector(_x._coord -p._x._coord,
                _y._coord -p._y._coord,
                _z._coord -p._z._coord);
    }
}