
package geometries;

/**
 * RadialGeometry is ana abstract class that defines
 * all radial geometries.
 */
public abstract class RadialGeometry implements Geometry {
    double _radius;

    /**
     * @param _radius
     */
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }

    public RadialGeometry() {
        RadialGeometry other = null;
        this._radius = other._radius;
    }

    public double get_radius() {
        return _radius;
    }
}