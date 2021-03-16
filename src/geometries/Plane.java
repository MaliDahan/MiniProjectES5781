package geometries;

import primitives.*;

public class Plane implements Geometry {
    final Point3D _q0;
    final Vector _normal;

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        _q0 = p1;

        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector N = U.crossProduct(V);

        N.normalize();

//        _normal = N.scale(-1);
        _normal = N;

    }

    public Plane(Point3D p, Vector n) {
        _q0 = p;
        _normal = n.normalize();
    }

    @Override
    public Vector getNormal(Point3D p) {
        return _normal;
    }

    /**
     * for polygon
     */
    public Vector getNormal() {
        return getNormal(null);
    }
}










