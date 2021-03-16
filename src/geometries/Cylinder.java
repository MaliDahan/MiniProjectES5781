package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Cylinder extends Tube {
    double _heightL;

    public Cylinder(Ray _axisRay ,double _height, double _radius) {
        super(_axisRay, _radius);
        _heightL=_height;
    }

    public double get_heightL() {
        return _heightL;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "ray=" + _ray +
                '}';
    }
    public Vector getNormal(Point3D p) {

            Point3D o = _ray.getPoint();
            Vector v = _ray.getDirection();
        /**
         * projection of P-O on the ray
          */
        double t;
        try {
            t = alignZero(p.subtract(o).dotProduct(v));
        }
        catch (IllegalArgumentException e) {
            return v;
        }

        if (t == 0 || isZero(_heightL - t))
            return v;

        o = o.add(v.scale(t));
        return p.subtract(o).normalize();
    }

}
