package primitives;

import java.util.List;

public class Ray {
    /**
     * The point where the ray starts.
     */
    private final Point3D _p0;
    /**
     * The direction of the ray.
     */
    private final Vector _direction;

    /**
     * Constructor for a new instance in this class
     * @param p0 the start of the ray.
     * @param direction of the ray.
     */
    public Ray(Point3D p0, Vector direction) {
        _p0 = p0;
        _direction = direction.normalized();
    }

    /**
     * Copy constructor for a deep copy of an Ray object.
     * @param other the object that being copied
     */
    public Ray(Ray other) {
        this._p0 = new Point3D(other._p0);
        this._direction = other._direction.normalized();
    }

    /**
     * Getter for the point from which the ray starts.
     * @return A new Point3D that represents the
     * point from which the ray starts.
     */
    public Point3D getPoint() {
        return new Point3D(_p0);
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

    /**
     * find the closest Point to Ray origin
     * @param pointsList intersections point List
     * @return closest point
     */
    public Point3D findClosestPoint(List<Point3D> pointsList){
        Point3D result =null;
        double closestDistance = Double.MAX_VALUE;

        if(pointsList== null){
            return null;
        }

        for (Point3D p: pointsList) {
            double temp = p.distance(_p0);
            if(temp < closestDistance){
                closestDistance =temp;
                result =p;
            }
        }

        return  result;
    }


    public Point3D getClosestPoint(List<Point3D> intersections) {
        Point3D result = null;
        if (intersections == null){
            return null;
        }
        double distance = Double.MAX_VALUE;
        for (Point3D p: intersections) {
            double newDist = _p0.distance(p);
            if (newDist< distance) {
                distance = newDist;
                result = p;
            }
        }
        return result;

    }
}