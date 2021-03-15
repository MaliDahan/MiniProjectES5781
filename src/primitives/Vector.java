package primitives;

import java.util.Objects;

import static primitives.Point3D.PointZERO;

public class Vector {
    Point3D _head;

    public Vector(Vector v) {
        this(v._head);
    }
    public Vector(Point3D p1, Point3D p2) {
        this(p1.subtract(p2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(_head, vector._head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_head);
    }

    public Vector(double x, double y, double z) {
        Point3D point=new Point3D(x,y,z);
       //_head._x= new Coordinate(x);
       //_head._y=new Coordinate(y);
       //_head._z=new Coordinate(z);
    }

    public Point3D getHead() {
        return new Point3D(_head._x,_head._y,_head._z);
    }

    public Vector(Point3D head) {
        if(head.equals(PointZERO)){
            throw new IllegalArgumentException("head cannot be point (0,0,0) ");
        }
        _head = head;
    }
    public Vector(Coordinate x, Coordinate   y, Coordinate z) {
        this(x._coord,y._coord, z._coord);
    }

    public void add(Vector vector) {
        _head.add(vector);
    }
    public void subtract(Vector vector) {
        _head.subtract(vector._head);
    }

    public Vector scale(double num) {
        return new Vector(
                new Point3D(
                        new Coordinate(num* _head._x._coord),
                        new Coordinate(num * _head._y._coord),
                        new Coordinate(num * _head._z._coord)));
    }

    public double dotProduct(Vector v) {
        return (_head._x._coord * v._head._x._coord +
                _head._y._coord * v._head._y._coord +
                _head._z._coord * v._head._z._coord);
    }
    public Vector crossProduct(Vector v) {
        double w1 = _head._y._coord * v._head._z._coord - _head._z._coord * v._head._y._coord;
        double w2 = _head._z._coord * v._head._x._coord - _head._x._coord * v._head._z._coord;
        double w3 = _head._x._coord * v._head._y._coord - _head._y._coord * v._head._x._coord;

        return new Vector(new Point3D(w1, w2, w3));
    }

    public double lengthSquared() {
        double xx = _head._x._coord * _head._x._coord;
        double yy = _head._y._coord * _head._y._coord;
        double zz = _head._z._coord * _head._z._coord;

        return xx + yy + zz;

    }
    public double length() {
        return Math.sqrt(lengthSquared());
    }
    /**
     * @return the same Vector after normalisation
     * @throws ArithmeticException if length = 0
     */
    public Vector normalize() {

        double x = _head._x._coord;
        double y = _head._y._coord;
        double z = _head._z._coord;

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide by Zero");

        this._head = new Point3D(x / length, y / length, z / length);

        return this;
    }

    public Vector normalized() {
        Vector vector = new Vector(this);
        vector.normalize();
        return vector;
    }

}