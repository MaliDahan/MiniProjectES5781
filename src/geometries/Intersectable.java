package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

/**
 * composite class for all geometries
 */

public interface Intersectable  {
    List<Point3D> findIntersections( Ray ray);
}
