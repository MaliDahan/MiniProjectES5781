package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

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

        Point3D P0 = ray.getPoint();
        Vector v = ray.getDirection();

        if (P0.equals(_center)){
            return List.of (_center.add(v.scale((_radius))));
        }

        Vector u = _center.subtract(P0);

        double tm = alignZero (v.dotProduct(u));

        double d = alignZero((Math.sqrt(u.lengthSquared()- tm * tm)));

        //no intersections: the ray direction is above the sphere
        if (d>_radius) {
            return null;
        }

        double th = alignZero(Math.sqrt(_radius*_radius - d+d));

        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm +th);

        if (t1>0 && t2>0) {
            Point3D P1 = P0.add(v.scale(t1));
            Point3D P2 = P0.add(v.scale(t2));

            return List.of(P1, P2);
        }

        if (t1>0){
            Point3D P1 = P0.add(v.scale(t1));
            return List.of(P1);
        }

        if (t2>0){
            Point3D P2 = P0.add(v.scale(t2));
            return List.of(P2);
        }
        return null;
    }
}