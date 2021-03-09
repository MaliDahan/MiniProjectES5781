package geometries;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

public abstract class Sphere extends RadialGeometry {
    Point3D _center;

    public Sphere(double _radius,Point3D _center) {
        super(_radius);
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

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }


}