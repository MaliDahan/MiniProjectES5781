package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Tube implements Geometry {
    protected final Ray _ray;
    final double _radius;

    public Tube(Ray _ray, double radius) {
        this._ray = new Ray(_ray);
        _radius = radius;
    }



    public Ray getRT() {
        return _ray;

    }

    @Override
    public String toString() {
        return "Tube{" +
                "ray=" + _ray +
                '}';
    }


    public Vector getNormal(Point3D p) {
        /**
         * The vector from the point of the cylinder to the given point
         */
        Point3D pt = _ray.getPoint();

        Vector v = _ray.getDirection();
        Vector P0 = p.subtract(p);
        /**
         * We need the projection to multiply the _direction unit vector
         */

        double projection = P0.dotProduct(v);

        if (!isZero(projection)) {
            pt = pt.add(v.scale(projection));
        }
        /**
         * This vector is orthogonal to the _direction vector.
         */
        Vector check = pt.subtract(pt);
        return check.normalize();
    }
}

