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
        _head._x= new Coordinate(x);
        _head._y=new Coordinate(y);
        _head._z=new Coordinate(z);
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
    public void add(Vector vector) {
        this._head.add(vector);
    }
    public void subtract(Vector vector) {
        this._head.subtract(vector._head);
    }

    public Vector scale(double scalingFacor) {
        return new Vector(
                new Point3D(
                        new Coordinate(scalingFacor * _head._x.coord),
                        new Coordinate(scalingFacor * _head._y.coord),
                        new Coordinate(scalingFacor * _head._z.coord)));
    }

    public double dotProduct(Vector v) {
        return (_head._x.coord * v._head._x.coord +
                _head._y.coord * v._head._y.coord +
                _head._z.coord * v._head._z.coord);
    }
    public Vector crossProduct(Vector v) {
        double w1 = _head._y.coord * v._head._z.coord - _head._z.coord * v._head._y.coord;
        double w2 = _head._z.coord * v._head._x.coord - _head._x.coord * v._head._z.coord;
        double w3 = _head._x.coord * v._head._y.coord - _head._y.coord * v._head._x.coord;

        return new Vector(new Point3D(w1, w2, w3));
    }

    public double lengthSquared() {
        double xx = this._head._x.coord * this._head._x.coord;
        double yy = this._head._y.coord * this._head._y.coord;
        double zz = this._head._z.coord * this._head._z.coord;

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

        double x = this._head._x.coord;
        double y = this._head._y.coord;
        double z = this._head._z.coord;

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide by Zero");

        _head._x = new Coordinate(x / length);
        _head._y = new Coordinate(y / length);
        _head._z = new Coordinate(z / length);

        return this;
    }

    public Vector normalized() {
        Vector vector = new Vector(this);
        vector.normalize();
        return vector;
    }

}
