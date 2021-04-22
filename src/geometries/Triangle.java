package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;

public class Triangle extends Polygon {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Triangle)) return false;

        Triangle tr = (Triangle) obj;


        return vertices.get(0).equals(tr.vertices.get(0)) &&
                vertices.get(1).equals(tr.vertices.get(1)) &&
                vertices.get(2).equals(tr.vertices.get(2));
    }


    @Override
    public String toString() {
        String result = "";
        for (Point3D p : vertices ) {
            result += p.toString();
        }
        return  result;
    }

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(new Point3D[]{p1, p2, p3});
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> ListOfPoint = plane.findIntersections(ray);
        if(ListOfPoint.size() == 0)
            return null;
        else {
            //𝑣1 = 𝑃1 − 𝑃0
            Vector v1 = this.vertices.get(0).subtract(ray.getPoint());
            //𝑣2 = 𝑃2 − 𝑃0
            Vector v2 = this.vertices.get(1).subtract(ray.getPoint());
            //𝑣3 = 𝑃3 − 𝑃0
            Vector v3 = this.vertices.get(2).subtract(ray.getPoint());
            //𝑁1 = 𝑛𝑜𝑟𝑚𝑎𝑙𝑖𝑧𝑒 𝑣1 × 𝑣2
            Vector N1 = v1.crossProduct(v2).normalize();
            //𝑁2 = 𝑛𝑜𝑟𝑚𝑎𝑙𝑖𝑧𝑒 𝑣2 × 𝑣3
            Vector N2 = v2.crossProduct(v3).normalize();
            //𝑁3 = 𝑛𝑜𝑟𝑚𝑎𝑙𝑖𝑧𝑒 𝑣3 × 𝑣1
            Vector N3 = v3.crossProduct(v1).normalize();

            //all bigger than 0
            boolean Bigger = alignZero(ray.getDirection().dotProduct(N1)) > 0 &&
                    alignZero(ray.getDirection().dotProduct(N2)) > 0 &&
                    alignZero(ray.getDirection().dotProduct(N3)) > 0;

            //all smaller than 0
            boolean Smaller = alignZero(ray.getDirection().dotProduct(N1)) < 0 &&
                    alignZero(ray.getDirection().dotProduct(N2)) < 0 &&
                    alignZero(ray.getDirection().dotProduct(N3)) < 0;

            if (Bigger || Smaller)
                return ListOfPoint;

            return null;

        }
    }
}
