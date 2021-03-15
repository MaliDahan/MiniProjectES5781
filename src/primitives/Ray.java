package primitives;

public class Ray {
    /**
     * The point where the ray starts.
     */
    private final Point3D _point;
    /**
     * The direction of the ray.
     */
    private final Vector _direction;

    /**
     * Constructor for a new instance in this class
     * @param point the start of the ray.
     * @param direction of the ray.
     */
    public Ray(Point3D point, Vector direction) {
        _point = point;
        _direction = direction.normalized();
    }

    /**
     * Copy constructor for a deep copy of an Ray object.
     * @param other the object that being copied
     */
    public Ray(Ray other) {
        this._point = new Point3D(other._point);
        this._direction = other._direction.normalized();
    }

    /**
     * Getter for the point from which the ray starts.
     * @return A new Point3D that represents the
     * point from which the ray starts.
     */
    public Point3D getPoint() {
        return new Point3D(_point);
    }
    /**
     * Getter for the direction of the ray
     * represented by this object.
     * @return A new Vector that represents the
     * direction of the ray
     * represented by this object.
     */
    public Vector getDirection() {
        return new Vector(_direction);
    }
}