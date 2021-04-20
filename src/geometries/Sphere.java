package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

public class Sphere extends RadialGeometry implements Geometry {
    final Point3D _center;


    public Sphere(double radius,Point3D center) {
        super(radius);
        _center=center;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        if (!(o instanceof Sphere)) return  false;
        Sphere other = (Sphere) o;
        return this._center.equals(other._center) && (Util.isZero(this._radius - other._radius));
    }

    public Point3D get_center() {

        return _center;
    }

    public Vector getNormal(Point3D p) {
        Vector normal = p.subtract(_center);
        return normal.normalize();
    }


    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}