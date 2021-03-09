package geometries;

import primitives.*;

public class Plane implements Geometry {
    Point3D _p;
    Vector _normal;

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        _p = new Point3D(p1);

        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector N = U.crossProduct(V);

        N.normalize();

        _normal = N.scale(-1);

    }

    public Plane(Point3D _p, Vector _normal) {
        _p = new Point3D(_p);
        _normal = new Vector(_normal);
    }

    @Override
    public Vector getNormal(Point3D p) {
        return _normal;
    }

    //because polygon
    public Vector getNormal() {
        return getNormal(null);
    }

}

