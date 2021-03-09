package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Cylinder extends Tube {
    double _heightL;

    public Cylinder(Ray MRT ,double _height ) {
        super(MRT);
        _heightL=_height;
    }

    public double get_heightL() {
        return _heightL;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "RT=" + RT +
                '}';
    }
    public Vector getNormal(Point3D p) {
        return null;
    }
}