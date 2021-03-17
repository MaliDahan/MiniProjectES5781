package primitives;

import java.util.Objects;

import static primitives.Point3D.PointZERO;

public class Vector {
    Point3D _head;

    public Vector(Point3D head) {
        if(head.equals(PointZERO)){
            throw new IllegalArgumentException("head cannot be point (0,0,0) ");
        }
        _head = head;
    }

    public Vector(double x, double y, double z) {
        this(new Point3D(x,y,z));
    }

    public Vector(Point3D p1, Point3D p2) {
        Point3D newPoint  = new Point3D(
                p2._x._coord-p1._x._coord,
                p2._y._coord-p1._y._coord,
                p2._z._coord-p1._z._coord
        );
        if(newPoint.equals(PointZERO)){
            throw new IllegalArgumentException("p1 == p2");
        }
        _head = newPoint;
    }

    public Vector(Vector v) {
        _head= v._head;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(_head, vector._head);
    }

    public Point3D getHead() {
        return new Point3D(_head._x,_head._y,_head._z);
    }

    public Vector add(Vector other){
        return new Vector(new Point3D(
                this._head._x._coord+other._head._x._coord,
                this._head._y._coord+other._head._y._coord,
                this._head._z._coord+other._head._z._coord));

    }

    public Vector subtract(Vector vector) {

        return new Vector(new Point3D(
                this._head._x._coord-vector._head._x._coord,
                this._head._y._coord-vector._head._y._coord,
                this._head._z._coord-vector._head._z._coord));
    }

    public Vector scale(double num) {
        return new Vector(
                new Point3D(
                        new Coordinate(num* _head._x._coord),
                        new Coordinate(num * _head._y._coord),
                        new Coordinate(num * _head._z._coord)));
    }

    public double dotProduct(Vector v) {
        return (this._head._x._coord * v._head._x._coord +
                this._head._y._coord * v._head._y._coord +
                this._head._z._coord * v._head._z._coord);
    }
    public Vector crossProduct(Vector v) {
        double w1 = this._head._y._coord * v._head._z._coord - this._head._z._coord * v._head._y._coord;
        double w2 = this._head._z._coord * v._head._x._coord - this._head._x._coord * v._head._z._coord;
        double w3 = this._head._x._coord * v._head._y._coord - this._head._y._coord * v._head._x._coord;

        return new Vector(new Point3D(w1, w2, w3));
    }

    public double lengthSquared() {
        double u1 = this._head._x._coord;
        double u2 = this._head._y._coord;
        double u3 = this._head._z._coord;

        return u1 * u1 + u2 * u2 + u3 * u3;
    }
    public double length() {
        return Math.sqrt(lengthSquared());
    }
    /**
     * @return the same Vector after normalisation
     * @throws ArithmeticException if length = 0
     */
    public Vector normalize() {

        double x = this._head._x._coord;
        double y = this._head._y._coord;
        double z = this._head._z._coord;

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