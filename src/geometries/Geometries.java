package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

/**
 * composite class for all geometries
 */
public class Geometries implements Intersectable{
    List<Intersectable> _intersectables;

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> result = null;
        for (Intersectable item: _intersectables) {
            List<Point3D> itemIntersectionPoints = item.findIntersections(ray);
            if (itemIntersectionPoints != null) {

                if (result == null){
                    result= new LinkedList<>();
                }
                result.addAll(itemIntersectionPoints);
            }
        }
        return result;

    }
}
